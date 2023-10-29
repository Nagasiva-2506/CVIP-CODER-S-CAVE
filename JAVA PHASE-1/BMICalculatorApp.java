//CREATING BMI CALCULATOR IN JAVA 


import java.util.Scanner;

class BMI //sub class for calculating BMI
	{
		//declaring variables
    private double weight;  
    private double height;

    public BMI(double weight, double height) //constructor with parameters
		{
        this.weight = weight;
        this.height = height;
		}

    public double calculateBMI() //method to calculate BMI 
		{
        if (height <= 0) 
			{
            throw new IllegalArgumentException("Height must be positive and non-zero.");
			}
        return weight / (height * height);
		}
	}
	//creating Interpreter that show's user category of BMI
class BMIInterpreter {
    public static String interpretBMI(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
public class BMICalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hey There welcome  to BMI Calculator...!");
        System.out.print("Enter your weight in kilograms: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();

        BMI bmiCalculator = new BMI(weight, height);
        double bmi = bmiCalculator.calculateBMI();

        System.out.println("Your BMI is: " + bmi);
        System.out.println("Interpretation: " + BMIInterpreter.interpretBMI(bmi));

        scanner.close();
    }
}