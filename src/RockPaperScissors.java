import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    final static int ROCK = 1;
    final static int PAPER = 2;
    final static int SCISSORS = 3;
    final static Random rand = new Random();

    public static void main(String[] args) {
        int userSelection = getInput();
        int botSelection = rand.nextInt(3) + 1;

        //System.out.printf("(i) Bot picked: %s%n", botSelection);

        switch (userSelection) {
            case ROCK:
                switch (botSelection) {
                    case ROCK -> draw();
                    case PAPER -> lose();
                    case SCISSORS -> win();
                }
                break;
            case PAPER:
                switch (botSelection) {
                    case ROCK -> win();
                    case PAPER -> draw();
                    case SCISSORS -> lose();
                }
                break;
            case SCISSORS:
                switch (botSelection) {
                    case ROCK -> lose();
                    case PAPER -> win();
                    case SCISSORS -> draw();
                }
                break;
            default:
                System.out.println("(!) You did not pick rock, paper, or scissors!");
                lose();
        }
    }

    /**
     * Gets a year from the user.
     *
     * @return The entered year.
     */
    private static int getInput() {
        try {
            var scanner = new Scanner(System.in);

            System.out.printf("(i) %s - Rock%n", ROCK);
            System.out.printf("(i) %s - Paper%n", PAPER);
            System.out.printf("(i) %s - Scissors%n", SCISSORS);
            System.out.print("(?) Enter a number to select one: ");
            return scanner.nextInt();
        } catch (InputMismatchException _e) {
            System.out.println("(!) Invalid input.  Please try again.\n");
            return getInput();
        }
    }

    /**
     * Called when the user wins against the bot.
     */
    private static void win() {
        System.out.println("(i) You win!");
    }

    /**
     * Called when the user loses to the bot.
     */
    private static void lose() {
        System.out.println("(i) You lose!");
    }

    /**
     * Called when the user and bot draw.  Re-runs the program.
     */
    private static void draw() {
        System.out.println("(i) It's a draw!\n");

        // Recurse.  We have to pass a string array to meet the call signature,
        // but since we don't parse any args the contents of the array do not
        // matter.
        main(new String[0]);
    }
}
