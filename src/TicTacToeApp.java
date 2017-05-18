import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by Julian on 18/05/2017.
 */
public class TicTacToeApp {

    public void startNewGame() {

        GameBoard tictactoe = new GameBoard();

        System.out.print("Welcome to Tic-Tac-Toe.");

        int moveCount = 0;
        boolean userHasWon = false;
        boolean compHasWon = false;

        while (moveCount < 9 && !userHasWon && !compHasWon) {
                if (moveCount == 0) {
                    System.out.print(" Please enter your first move: ");
                } else {
                    System.out.print("Please enter your next move: ");
                }
                String userMove = Keyboard.readInput();
            /*Parse current move*/
                Move currentMove = tictactoe.parseMove(userMove);
            /*Validate current move*/
                if (!tictactoe.validateMove(currentMove)) {
                    System.out.println("You have entered an invalid move");
                    continue;
                }

                tictactoe.makeMove(currentMove, "X");

                tictactoe.printGameBoard();
                moveCount++;
                System.out.println("Move number: " + moveCount);
                /*Check if move will win the game*/
                if (tictactoe.winningMove(currentMove, "X")) {
                userHasWon = true;
            }
        }
        if (userHasWon){
            System.out.println("The Player has defeated the Computer!");
        } else if (compHasWon){
            System.out.println("The Computer has defeated the Player!");
        } else {
            System.out.println("The match is a draw...");
        }
    }


    public static void main(String[] args) {
        TicTacToeApp newGame = new TicTacToeApp();
        boolean stillPlaying = true;

        while(stillPlaying) {
            System.out.println("Would you like to start a new game? (y) Yes, (q) Quit");
            String userIntention = Keyboard.readInput().toLowerCase();

            if (userIntention.equals("y")) {
                newGame.startNewGame();
            } else if (userIntention.equals("q")) {
                System.out.println("Thank you for playing");
                stillPlaying = false;
            } else {
                System.out.println("We could not recognise your input, please try again");
                continue;
            }
        }
    }

}
