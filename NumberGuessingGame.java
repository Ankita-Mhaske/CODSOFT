import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1; // Random number from 1 to 100
            int attempts = 0;
            int maxAttempts = 10; // You can change this to allow more or unlimited tries
            boolean numberGuessed = false;

            System.out.println("\nI have picked a number between 1 and 100.");
            System.out.println("Try to guess it! You have " + maxAttempts + " attempts.");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                
                // Ensure valid number input
                while (!scanner.hasNextInt()) {
                    System.out.print("Invalid input! Enter a valid number: ");
                    scanner.next();
                }
                
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println(" Congratulations! You guessed the number in " + attempts + " attempts.");
                    numberGuessed = true;
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println(" Too low! Try again.");
                }
                
                // Display attempts remaining
                if (attempts < maxAttempts) {
                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println(" Out of attempts! The correct number was: " + targetNumber);
                }
            }

            // Display Score
            int score = numberGuessed ? (maxAttempts - attempts + 1) * 10 : 0;
            System.out.println("⭐ Your Score: " + score);

            // Ask if user wants to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nThank you for playing! 🎮");
        scanner.close();
    }
}
