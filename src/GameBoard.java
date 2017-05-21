import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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
        System.out.println("Move has been validated");
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
            int checkColInt = 'A' + i;
            char checkCol = (char) checkColInt;
            String colA = rows.get(i).squareFilledBy(checkCol);
            String colB = rows.get(i).squareFilledBy("B");
            String colC = rows.get(i).squareFilledBy("C");
            System.out.println("ColA, row" + i + " = " + colA);
            System.out.println("ColB, row" + i + " = " + colB);
            System.out.println("ColC, row" + i + " = " + colC);
            if (colA != " " && colA.equals(colB) && colB.equals(colC)){
                return true;
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
        Move move;
        if (moveString.length() > 2 || (moveString.charAt(1) <= '1' && moveString.charAt(1) >= '9')) {
            move = new Move("D4");
        }
        else {
            /*If no immediately obvious issues with input, parse move*/
            move = new Move(moveString);
        }
        return move;
    }

}
