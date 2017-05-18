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

        return rows.get(rowNum).validateMove(colAlpha);
    }

    public boolean winningMove(Move move) {
        boolean winningMove = false;

        String colAlpha = move.getColAlpha();
        int rowNum = move.getRowNum();



        return winningMove;
    }

    public Move parseMove (String moveString){
        Move move = new Move(moveString);
        return move;
    }

}
