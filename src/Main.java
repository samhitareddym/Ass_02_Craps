import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Craps game!");

        // Game loop
        while (playAgain) {
            System.out.println("Rolling the dice...");

            // Roll two dice and calculate sum
            int dice1 = rand.nextInt(6) + 1;
            int dice2 = rand.nextInt(6) + 1;
            int sum = dice1 + dice2;

            // Show rolled dice values and sum
            System.out.println("You rolled " + dice1 + " + " + dice2 + " : " + sum);

            // Initial roll conditions
            if (sum == 7 || sum == 11) {
                System.out.println("Natural, You win!");
            } else if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out and lost.");
            } else {
                int point = sum;
                System.out.println("The point now is " + point + ".");
                boolean pointAchieved = false;

                // Subsequent rolls to match the point or roll a 7
                while (!pointAchieved) {
                    System.out.println("Rolling for the point...");
                    dice1 = rand.nextInt(6) + 1;
                    dice2 = rand.nextInt(6) + 1;
                    sum = dice1 + dice2;

                    System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("You made your point! You win!");
                        pointAchieved = true;
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7. You lose!");
                        pointAchieved = true;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            // Ask if the user wants to play again
            System.out.print("Would you like to play again? (Y/N): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("Y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}

