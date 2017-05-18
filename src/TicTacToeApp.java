/**
 * Created by Julian on 18/05/2017.
 */
public class TicTacToeApp {

    public void startNewGame() {

        GameBoard tictactoe = new GameBoard();

        System.out.print("Welcome to Tic-Tac-Toe. Please enter your first move: ");

        int moveCount = 0;
        boolean userHasWon = false;
        boolean compHasWon = false;

        while (moveCount < 9 || !userHasWon || !compHasWon) {

            String userMove = Keyboard.readInput();


            tictactoe.printGameBoard();
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

            } else {
                System.out.println("We could not recognise your input, please try again");
                continue;
            }
        }
    }

}
