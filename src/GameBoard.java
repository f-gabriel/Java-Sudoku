import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class GameBoard {
    public NumberTile[][] gameBoard = new NumberTile[9][9];

    GameBoard(){
        for(int row = 0; row <= 8; row++){
            for(int column = 0; column <= 8; column++){
                this.gameBoard[row][column] = new NumberTile(row,column);
            }
        }
    }
    GameBoard(GameBoard gameBoard){
        for(int row = 0; row <= 8; row++){
            this.gameBoard[row] = gameBoard.gameBoard[row];
        }
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

    public NumberTile getNumberTileAtPos(int row, int column){
        return gameBoard[row][column];
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
    public static ArrayList<Integer> translateNumberTileToInts(NumberTile[] nSquareList, VALUETYPE valuetype){
        return SudokuStringRepresentation.translateNumberTileToInts(nSquareList, valuetype);
    }
    public NumberTile[][] gameBoardToArray(GameBoard gBoard) {
        NumberTile[][] tileArray = new NumberTile[9][9];
        System.arraycopy(gBoard.gameBoard, 0, this.gameBoard, 0, 9);
        return tileArray;
    }

    // todo: flytta ut denna
    void createSolvedGameBoard(){
        SudokuSolver ss = new SudokuSolver();
        this.gameBoard = gameBoardToArray(ss.solveSudoku());
    }
}
