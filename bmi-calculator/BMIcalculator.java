import java.util.Scanner;
import java.text.DecimalFormat;

public class BMIcalculator {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter weight in pounds:");
        double weight = input.nextDouble();

        System.out.println("Enter height feet:");
        int heightFeet = input.nextInt();

        System.out.println("Enter height inches:");
        int heightInches = input.nextInt();

        int totalHeightInInches = (heightFeet * 12) + heightInches;
        input.close();

		double bmi = weight / Math.pow(totalHeightInInches, 2) * 703; //height, the power of 2

		DecimalFormat df = new DecimalFormat("0.00");//Your BMI is: 0.00
		System.out.println("Your BMI is: "+ df.format(bmi));

	}
}