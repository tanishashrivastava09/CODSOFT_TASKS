import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int roundsWon = 0;
        int round = 1;
        String playAgain;

        System.out.println("====================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("====================================");

        do {

            int secretNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\n---------- ROUND " + round + " ----------");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                System.out.print("\nAttempt " + attempt + "/" + maxAttempts
                        + " - Enter your guess: ");

                int guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    attempt--;
                    continue;
                }

                if (guess == secretNumber) {

                    guessedCorrectly = true;
                    roundsWon++;

                    // Higher score for fewer attempts
                    int score = (maxAttempts - attempt + 1) * 10;
                    totalScore += score;

                    System.out.println("\n🎉 CORRECT!");
                    System.out.println("You guessed the number in "
                            + attempt + " attempts.");
                    System.out.println("You earned " + score + " points.");

                    break;

                } else if (guess < secretNumber) {

                    System.out.println("Too LOW! Try a higher number.");

                } else {

                    System.out.println("Too HIGH! Try a lower number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\n❌ GAME OVER!");
                System.out.println("You used all " + maxAttempts + " attempts.");
                System.out.println("The correct number was: " + secretNumber);
            }

            // Display current score
            System.out.println("\n========== SCORE ==========");
            System.out.println("Rounds Played : " + round);
            System.out.println("Rounds Won    : " + roundsWon);
            System.out.println("Total Score   : " + totalScore);
            System.out.println("===========================");

            // Ask for another round
            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = sc.next();

            round++;

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n====================================");
        System.out.println("          FINAL SCORE");
        System.out.println("====================================");
        System.out.println("Total Rounds Played : " + (round - 1));
        System.out.println("Rounds Won          : " + roundsWon);
        System.out.println("Total Score         : " + totalScore);

        System.out.println("\nThank you for playing!");
        System.out.println("====================================");

        sc.close();
    }
}
