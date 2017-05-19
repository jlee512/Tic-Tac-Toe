import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 19/05/2017.
 */
public class GameBoard {

    private List<Row> rows = new ArrayList<>();
    private boolean hasWon;
    private boolean hasLost;

    GameBoard () {
        /*Add rows to the game board*/
        rows.add(new Row(RowType.TOP));
        rows.add(new Row(RowType.MIDDLE));
        rows.add(new Row(RowType.BOTTOM));

        /*Set win and lost status to false*/
        hasWon = false;
        hasLost = false;
    }

    public void printGameBoard() {
        for (Row row : rows) {
            System.out.println(row.toString());
        }
    }

    public boolean validateMove(Move move){
        String colAlpha = move.getColAlpha();
        int rowNum = move.getRowNum();
        colAlpha = colAlpha.toUpperCase();

        /*Check row number and column alpha are part of the board are */
        if(colAlpha.charAt(0) < 'A' || colAlpha.charAt(0) > 'C'){
            return false;
        } else if (rowNum < 1 || rowNum > 3){
            return false;
        }
        /*If selection is part of the board, check the space is not taken*/
        return rows.get(rowNum - 1).validateMove(colAlpha);
    }

    public boolean winningMove(Move move, String playerSymbol) {

        String colAlpha = move.getColAlpha().toUpperCase();
        int rowNum = move.getRowNum();

        /* Check all row has same symbol*/
        for (Row row : rows) {
            if(row.allRowWon(colAlpha, playerSymbol)){
                return true;
            }
        }
        /* Check all col has same symbol*/
        for (int i = 0; i < 3; i++) {
//            System.out.println("Row: " + i);
            String colA = rows.get(i).squareFilledBy("A");
            String colB = rows.get(i).squareFilledBy("B");
            String colC = rows.get(i).squareFilledBy("C");
//            System.out.println(colA);
//            System.out.println(colB);
//            System.out.println(colC);
            if (colA != " " && colA.equals(colB) && colB.equals(colC)){

            }
        }

        return false;
    }

    public void makeMove(Move move, String playerSymbol){
        String colAlpha = move.getColAlpha();
        int rowNum = move.getRowNum();
        colAlpha = colAlpha.toUpperCase();

        rows.get(rowNum - 1).addMove(colAlpha, playerSymbol);
    }

    public Move parseMove (String moveString){
        /* Validate that move is a two character String and that the second character is an integer, otherwise set move to default error string that will be caught by validation function*/
        System.out.println(moveString.length());
        if (moveString.length() > 2){
            Move move = new Move("D4");
        }

//        colAlpha = moveString.substring(0,1);
//        rowNum = Integer.parseInt(moveString.substring(1));

        else {
            /*If no immediately obvious issues with input, parse move*/
            Move move = new Move(moveString);
            return move;
        }
    }

}
