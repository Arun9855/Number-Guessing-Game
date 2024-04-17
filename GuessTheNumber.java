package Project;

import javax.swing.JOptionPane;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int totalRounds = 3; // Number of rounds
        int maxAttempts = 5; // Limiting the number of attempts
        int totalScore = 0;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number!");

        for (int round = 1; round <= totalRounds; round++) {
            Random random = new Random();
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int roundScore = 0;

            JOptionPane.showMessageDialog(null, "Round " + round + ": I have selected a number between " + minRange
                    + " and " + maxRange + ". Try to guess it.");

            while (attempts < maxAttempts) {
                String guessString = JOptionPane.showInputDialog("Enter your guess:");
                if (guessString == null) // User pressed cancel
                    break;

                int guess = Integer.parseInt(guessString);
                attempts++;

                if (guess == targetNumber) {
                    roundScore = maxAttempts - attempts + 1; // Give points based on the number of attempts
                    totalScore += roundScore;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts
                            + " attempts. Round Score: " + roundScore);
                    break;
                } else if (guess < targetNumber) {
                    JOptionPane.showMessageDialog(null, "The number is higher than your guess. Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "The number is lower than your guess. Try again.");
                }
            }

            if (roundScore == 0) {
                JOptionPane.showMessageDialog(null,
                        "Sorry, you've reached the maximum number of attempts. The correct number was: "
                                + targetNumber);
            }
        }

        JOptionPane.showMessageDialog(null, "Game Over! Your Total Score: " + totalScore);
    }
}
