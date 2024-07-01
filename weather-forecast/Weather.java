import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONObject;

public class Weather {
    private static final String API_KEY = "af245905885a7476bac97bc18658910e";
    private static final String BASE_API_URL = "https://api.openweathermap.org/data/2.5/weather?";

    public static void main(String[] args) {
        String location;
        
        if (args.length > 0) {
            location = String.join(" ", args);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a location (city name): ");
            location = scanner.nextLine();
            scanner.close();
        }

        try {
            HttpClient client = HttpClient.newHttpClient();
            String apiUrl = BASE_API_URL + "q=" + location + "&appid=" + API_KEY;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject json = new JSONObject(response.body());
                JSONObject main = json.getJSONObject("main");
                double tempK = main.getDouble("temp");
                double tempC = tempK - 273.15;
                
                int humidity = main.getInt("humidity");
                String condition = json.getJSONArray("weather").getJSONObject(0).getString("description");

                System.out.println("Weather in " + location + ":");
                System.out.println("Temperature: " + String.format("%.2f", tempC) + "°C");
                System.out.println("Condition: " + condition);
                System.out.println("Humidity: " + humidity + "%");
            } else if (response.statusCode() == 404) {
                System.out.println("Error: City '" + location + "' not found.");
            } else {
                System.out.println("Error: Unable to fetch data. Status code: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

