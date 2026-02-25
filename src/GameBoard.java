import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class GameBoard {
    NumberTile[][] gameBoard = new NumberTile[9][9];

    GameBoard(){
        while (!isSolvable()) {createGameBoard();}}
    
    void createGameBoard(){
        this.gameBoard = new NumberTile[9][9];
        for(int row = 0; row <= 8; row++){
            for(int column = 0; column <= 8; column++){
                NumberTile ns = new NumberTile(row, column);
                List<Integer> nonavailableNumbers = findNonAvailableNumbers(ns);
                if (nonavailableNumbers.size() == 9) {
                    break;
                }
                ns.assignValue(nonavailableNumbers);
                gameBoard[row][column] = ns;}
        }
    }

    public boolean isSolvable(){
        boolean solvable = true;
        for(NumberTile[] row : gameBoard){
            if (!solvable){break;}
            for(NumberTile nTile : row){
                solvable = nTile != null;
                if (!solvable){break;} }
        }
        return solvable;
    }

    public NumberTile[] getRow(NumberTile nTile){
        return gameBoard[nTile.getRowNumber()];}
    public NumberTile[] getRow(int row){
        return gameBoard[row];}

    public NumberTile[] getColumn(NumberTile nTile){
        NumberTile[] column = new NumberTile[9];
        for(int i = 0; i <= 8; i++ ) {
            column[i] = gameBoard[i][nTile.getColumnNumber()];
        }
        return column;
    }
    public NumberTile[] getSquare(NumberTile nTile){
        NumberTile[] square = new NumberTile[9];
        int squareNumber = nTile.getSquareNumber();
        int column_number = 3 * (((squareNumber) % 3));
        int row_number = (squareNumber - (squareNumber % 3));
        for(int row = 0; row <= 2; row++){
            for(int column = 0; column <= 2; column++){
                int square_index = 3 * row + column;
                square[square_index] = gameBoard[row + row_number][column + column_number];}
        }
        return square;
    }
    public NumberTile getNumberTileAtPos(int row, int column){return gameBoard[row][column];}

    ArrayList<Integer> findNonAvailableNumbers(NumberTile nTile){
        LinkedHashSet<Integer> nonviables = new LinkedHashSet<>();
        List<Integer> row = translateNumberTileToInts(getRow(nTile), VALUETYPE.REAL);
        for(int number : row){
            if(number != 0) {nonviables.add(number);}
        }
        List<Integer> column = translateNumberTileToInts(getColumn(nTile), VALUETYPE.REAL);
        for(int number : column){
            if(number != 0) {nonviables.add(number);}
        }
        List<Integer> square = translateNumberTileToInts(getSquare(nTile), VALUETYPE.REAL);
        for(int number : square){
            if(number != 0) {nonviables.add(number);}
        }
        return new ArrayList<>(nonviables);
    }

    public int[][] sudokuIntRepresentation(VALUETYPE valuteType){
        int[][] representation = new int[9][9];
        for(int row = 0; row <= 8; row++){
            List<Integer> rowList = translateNumberTileToInts(getRow(row), valuteType);
            int[] intList = new int[9];
            for(int i = 0; i <= 8; i++){
                intList[i] = rowList.get(i);}
            representation[row] = intList;}
        return representation;
    }
    public String toString(){
        int[][] sudoku = sudokuIntRepresentation(VALUETYPE.REAL);
        SudokuStringRepresentation sr = new SudokuStringRepresentation(sudoku);
        return sr.toString();
    }
    public ArrayList<Integer> translateNumberTileToInts(NumberTile[] nSquareList, VALUETYPE valuetype){
        return SudokuStringRepresentation.translateNumberTileToInts(nSquareList, valuetype);
    }


}
