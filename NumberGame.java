import java.util.*;
public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("********* GUESS A RANDOM NUMBER! *********");
        System.out.println("Guess a number between 1 and 100");
        System.out.println("You can make 5 maximum guesses");

        boolean game = true;

        while (game) {

            Random randomNum = new Random();
            int random = randomNum.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;
            boolean correctGuess = false;

            while (attempts < maxAttempts) {

                System.out.print("Enter a number: ");
                int n = sc.nextInt();
                attempts++;

                if (n == random) {
                    System.out.println("Hurray! You guessed the number correctly: " + n);
                    correctGuess = true;
                    break;
                }

                if (attempts == maxAttempts) {
                    break;
                }

                if (n > random) {
                    System.out.println("Guess lower!");
                } else {
                    System.out.println("Guess higher!");
                }

                System.out.println("Number of guesses left: " + (maxAttempts - attempts));
            }

            if (!correctGuess) {
                System.out.println("Better luck next time! The random number is " + random);
            }

            System.out.print("Do you want to play again? Y/N: ");
            char ch = sc.next().toLowerCase().charAt(0);

            if (ch != 'y') {
                game = false;
                System.out.println("Thanks for playing!");
            }
        }

        sc.close();
    }
}
