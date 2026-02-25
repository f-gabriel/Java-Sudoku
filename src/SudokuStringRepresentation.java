import java.util.ArrayList;
import java.util.List;

public class SudokuStringRepresentation implements IHasSudokuStringRepresentation {
    int[][] gameBoard;

    SudokuStringRepresentation(int[][] gameBoard){
        this.gameBoard = gameBoard;
    }

    public String toString(){
        StringBuilder returnString = new StringBuilder();
        for(int row = 0; row <= 8; row++) {returnString.append(rowToString(row));}
        return returnString.toString();
    }
    String rowToString(int row){
        StringBuilder returnString = new StringBuilder();
        if (row != 0) {
            returnString.append("\n");
            if ((row) % 3 == 0) {
                returnString.append("_____________________\n");}
        }
        returnString.append(columnToString(row));
        return returnString.toString();
    }
    String columnToString(int row ){
        StringBuilder returnString = new StringBuilder();
        for (int place = 0; place <= 8; place++) {
            if (gameBoard[row][place] == 0) { // should be getInputValue()
                returnString.append("_ ");
            } else {
                returnString.append(gameBoard[row][place] + " ");
            }
            if((place + 1) % 3 == 0 && place != 8){
                returnString.append("| ");}
        }
        return returnString.toString();
    }

    public static ArrayList<Integer> translateNumberTileToInts(NumberTile[] nTileList, VALUETYPE valuetype){
        ArrayList<Integer> values = new ArrayList<>();
        for(NumberTile tile : nTileList){
            if(tile != null) {values.add(tile.getValue(valuetype));}
        }
        return values;
    }
}
