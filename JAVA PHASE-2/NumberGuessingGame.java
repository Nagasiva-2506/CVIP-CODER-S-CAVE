import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ". You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                try {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();

                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed the correct number (" + targetNumber + ") in " + (attempts + 1) + " attempts.");
                        score++;
                        break;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Too low! Try a higher number.");
                    } else {
                        System.out.println("Too high! Try a lower number.");
                    }

                    attempts++;
                    int remainingAttempts = maxAttempts - attempts;
                    System.out.println("You have " + remainingAttempts + " attempts remaining.");

                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Clear the invalid input from the scanner buffer.
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.toLowerCase().equals("yes")) {
                System.out.println("Thanks for playing! Your score: " + score);
                break;
            }
        }

        scanner.close();
    }
}
