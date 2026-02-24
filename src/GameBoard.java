import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class GameBoard {
    NumberSquare[][] gameBoard = new NumberSquare[9][9];

    GameBoard(){
        while (!isSolvable()){createGameBoard();}}
    
    void createGameBoard(){
        this.gameBoard = new NumberSquare[9][9];
        for(int row = 0; row <= 8; row++){
            for(int column = 0; column <= 8; column++){
                NumberSquare ns = new NumberSquare(row, column);
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
        for(NumberSquare[] row : gameBoard){
            if (!solvable){break;}
            for(NumberSquare nSquare : row){
                solvable = nSquare != null;
                if (!solvable){break;}
            }
        }
        return solvable;
    }
    public NumberSquare[] getRow(NumberSquare nSquare){
        return gameBoard[nSquare.getRowNumber()];}
    public NumberSquare[] getRow(int row){
        return gameBoard[row];}
    public NumberSquare[] getColumn(NumberSquare nSquare){
        NumberSquare[] column = new NumberSquare[9];
        for(int i = 0; i <= 8; i++ ) {
            column[i] = gameBoard[i][nSquare.getColumnNumber()];
        }
        return column;
    }
    public NumberSquare[] getSquare(NumberSquare nSquare){
        NumberSquare[] square = new NumberSquare[9];
        int squareNumber = nSquare.getSquareNumber();
        int column_number = 3 * (((squareNumber) % 3));
        int row_number = (squareNumber - (squareNumber % 3));
        for(int row = 0; row <= 2; row++){
            for(int column = 0; column <= 2; column++){
                int square_index = 3 * row + column;
                square[square_index] = gameBoard[row + row_number][column + column_number];}
        }
        return square;
    }
    public NumberSquare getNumberSquareAtPos(int row, int column){return gameBoard[row][column];}

    List<Integer> findNonAvailableNumbers(NumberSquare nSquare){
        LinkedHashSet<Integer> nonviables = new LinkedHashSet<>();
        List<Integer> row = translateNumberSquaresToInts(getRow(nSquare), VALUETYPE.REAL);
        for(int number : row){
            if(number != 0) {nonviables.add(number);}
        }
        List<Integer> column = translateNumberSquaresToInts(getColumn(nSquare), VALUETYPE.REAL);
        for(int number : column){
            if(number != 0) {nonviables.add(number);}
        }
        List<Integer> square = translateNumberSquaresToInts(getSquare(nSquare), VALUETYPE.REAL);
        for(int number : square){
            if(number != 0) {nonviables.add(number);}
        }
        return new ArrayList<>(nonviables);
    }
    public int[][] sudokuIntRepresentation(VALUETYPE valuteType){
        int[][] representation = new int[9][9];
        for(int row = 0; row <= 8; row++){
            List<Integer> rowList = translateNumberSquaresToInts(getRow(row), valuteType);
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
    public List<Integer> translateNumberSquaresToInts(NumberSquare[] nSquareList, VALUETYPE valuetype){
        return SudokuStringRepresentation.translateNumberSquaresToInts(nSquareList, valuetype);
    }


}
