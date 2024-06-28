import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Alarm Clock!");

        // User input
        System.out.print("Enter the alarm time (hh:mm): ");
        String alarmTimeStr = scanner.nextLine();

        // Parse the user input
        LocalTime alarmTime = LocalTime.parse(alarmTimeStr);

        System.out.println("Alarm set for " + alarmTime);

        // Loop to check current time
        boolean alarmTriggered = false;
        while (!alarmTriggered) {
            LocalTime currentTime = LocalTime.now();

            if (currentTime.isAfter(alarmTime)) {
                System.out.println("Alarm! It's " + currentTime + ". Time to wake up!");
                alarmTriggered = true;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        scanner.close();
    }
}
