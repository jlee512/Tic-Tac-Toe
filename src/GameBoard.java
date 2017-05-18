import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 19/05/2017.
 */
public class GameBoard {

    private List<Row> rows = new ArrayList<>();

    GameBoard () {
        rows.add(new Row(RowType.TOP));
        rows.add(new Row(RowType.MIDDLE));
        rows.add(new Row(RowType.BOTTOM));
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
        for (int i = 0; i < 2; i++) {
            String row1 = rows.get(i).squareFilledBy(playerSymbol);
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
        Move move = new Move(moveString);
        return move;
    }

}
