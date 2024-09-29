import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int roundsPlayed = 0;

        while (true) {
            roundsPlayed++;
            int attempts = playGame(random, scanner);
            totalScore += (10 - attempts) > 0 ? (10 - attempts) : 0;

            System.out.println("Your current score is: " + totalScore);
            System.out.print("Would you like to play again? (yes/no): ");
            String playAgain = scanner.next().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing! You played " + roundsPlayed + " rounds with a total score of " + totalScore + ".");
        scanner.close();
    }

    private static int playGame(Random random, Scanner scanner) {
        int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
        int attempts = 0;
        int maxAttempts = 10;

        System.out.println("I have generated a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + attempts + " attempts!");
                return attempts; // Return attempts for scoring
            }
        }

        System.out.println("Sorry, you've used all your attempts! The number was " + numberToGuess + ".");
        return maxAttempts; // Return max attempts if not guessed
    }
}
