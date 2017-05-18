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

        while (moveCount < 9 || !userHasWon || !compHasWon) {
            if (moveCount == 0 || (moveCount % 2 == 0)){
            if (moveCount == 0){
                System.out.print(" Please enter your first move: ");
            } else {
                System.out.print("Please enter your next move: ");
            }
            String userMove = Keyboard.readInput();
            /*Parse current move*/
            Move currentMove = tictactoe.parseMove(userMove);
            /*Validate current move*/
            if(!tictactoe.validateMove(currentMove)){
                System.out.println("You have entered an invalid move");
                continue;
            }
            /*Check if move will win the game*/
            else if (tictactoe.winningMove(currentMove)) {

            }

            System.out.println(userMove);

            tictactoe.printGameBoard();
            moveCount++;
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
