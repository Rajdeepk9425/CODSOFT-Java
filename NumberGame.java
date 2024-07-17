import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class NumberGame 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) 
        {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            int maxAttempts = 10;

            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) 
            {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) 
                {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1; // More attempts left, higher the score
                    hasGuessedCorrectly = true;
                } else if (userGuess < numberToGuess) 
                {
                    System.out.println("Too low! Try again.");
                } 
                else
                {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!hasGuessedCorrectly) 
            {
                System.out.println("Sorry! You've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
    }
}