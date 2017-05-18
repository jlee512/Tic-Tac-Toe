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

        if (row.get("A") != null){
            colA = row.get("A");
        } else if (row.get("B") != null){
            colB = row.get("B");
        } else if (row.get("C") != null) {
            colC = row.get("C");
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
        if (row.get(colAlpha) != null){
            return false;
        }



        return validMove;
    }

    public void addMove (String colAlpha, String playerSymbol) {
        row.put(colAlpha, playerSymbol);
    }

}
