import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Julian on 18/05/2017.
 */
public class Row {

    public Map<String, String> row = new HashMap<>();
    public RowType rowType;
    public int rowNum;

    Row (RowType rowType){
        /* Set the row type*/
        this.rowType = rowType;
        /* set the Row Number*/
        switch (rowType) {
            case TOP:
                rowNum = 1;
                break;
            case MIDDLE:
                rowNum = 2;
                break;
            case BOTTOM:
                rowNum = 3;
                break;
        }
        /*Setup row map with blank values prior to player selection*/
        row.put("A" + rowNum, " ");
        row.put("B" + rowNum, " ");
        row.put("C" + rowNum, " ");
    }

    public String toString() {

        /*Check whether row has an entry*/
        String colA = " ";
        String colB = " ";
        String colC = " ";

        if (row.get("A" + rowNum) != null){
            colA = row.get("A" + rowNum);
        }
        if (row.get("B" + rowNum) != null){
            colB = row.get("B" + rowNum);
        }
        if (row.get("C" + rowNum) != null) {
            colC = row.get("C" + rowNum);
        }

        /*Change row output depending on row position (top, middle or bottom)*/
        if (rowType == RowType.TOP) {
            return " " + colA + " | " + colB + " | " + colC + "\n" + "---|---|---";
        }
        else if (rowType == RowType.MIDDLE) {
            return " " + colA + " | " + colB + " | " + colC;
        }
        else {
            return "---|---|---" + "\n" + " " + colA + " | " + colB + " | " + colC;
        }
    }

    public boolean validateMove(String colAlpha){
        boolean validMove = true;

        /*If column is already taken, move is invalid*/
        if (!row.get(colAlpha + rowNum).equals(" ")){
            return false;
        }
        return validMove;
    }

    public void addMove (String colAlpha, String playerSymbol) {
        row.put(colAlpha + rowNum, playerSymbol);
    }

    public boolean allRowWon (String colAlpha, String playerSymbol){
        if(row.get(colAlpha + rowNum).equals(playerSymbol)) {
            return (row.get("A" + rowNum).equals(playerSymbol) && row.get("B" + rowNum).equals(playerSymbol) && row.get("C" + rowNum).equals(playerSymbol));
        } else {
            return false;
        }
    }

    public String squareFilledBy(String colAlpha){
        return row.get(colAlpha + rowNum);
    }

}
