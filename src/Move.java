/**
 * Created by Julian on 19/05/2017.
 */
public class Move {

    String colAlpha;
    int rowNum;

    public Move(String move){
        this.colAlpha = move.substring(0,1);
        this.rowNum = Integer.parseInt(move.substring(1));
    }

    public String getColAlpha() {
        return colAlpha;
    }

    public int getRowNum() {
        return rowNum;
    }
}
