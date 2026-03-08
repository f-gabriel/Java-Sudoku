package OldSudoku.Model;

import OldSudoku.Enums.VALUETYPE;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class SudokuSolver {
    public GameBoard gameBoard = new GameBoard();

    public SudokuSolver(){
        this.gameBoard = new GameBoard();
    }
    public SudokuSolver(GameBoard startTiles){
        this.gameBoard = startTiles;}

    public SudokuSolver(NumberTile[] startTiles){
        this.gameBoard = gameBoardMaker(startTiles);
    }

    public GameBoard gameBoardMaker(NumberTile[] startTiles){
        GameBoard gb = new GameBoard();
        for(NumberTile startTile : startTiles){
            int row = startTile.row;
            int column = startTile.column;
            gb.gameBoard[row][column] = startTile;
        }
        return gb;
    }

    public GameBoard solveSudoku(VALUETYPE valuetype){
        while (!isSolvable(valuetype)) {
            this.gameBoard = new GameBoard();
            for (int row = 0; row <= 8; row++) {
                for (int column = 0; column <= 8; column++) {
                    NumberTile ns = gameBoard.getNumberTileRepresentation(row, column);
                    List<Integer> nonavailableNumbers = findNonAvailableNumbers(ns);
                    if (nonavailableNumbers.size() == 9) {
                        break;
                    }
                    ns.assignValueOfType(valuetype, nonavailableNumbers);
                    gameBoard.gameBoard[row][column] = ns;
                }
            }
        }
        return gameBoard;
    }

    // Checks that each coordinate on the board has a OldSudoku.Model.NumberTile and that the realValue for each != 0
    public boolean isSolvable(VALUETYPE valuetype){
        boolean solvable = true;
        for(NumberTile[] row : gameBoard.gameBoard){
            if (!solvable){break;}
            for(NumberTile nTile : row){
                solvable = nTile != null && nTile.getValueOfType(valuetype) != 0;
                if (!solvable){break;} }
        }
        return solvable;
    }

    ArrayList<Integer> findNonAvailableNumbers(NumberTile nTile){
        LinkedHashSet<Integer> nonviables = new LinkedHashSet<>();
        List<Integer> row = GameBoard.translateNumberTileToInts(gameBoard.getRow(nTile), VALUETYPE.REAL);
        for(int number : row){
            if(number != 0) {nonviables.add(number);}
        }
        List<Integer> column = GameBoard.translateNumberTileToInts(gameBoard.getColumn(nTile), VALUETYPE.REAL);
        for(int number : column){
            if(number != 0) {nonviables.add(number);}
        }
        List<Integer> square = GameBoard.translateNumberTileToInts(gameBoard.getSquare(nTile), VALUETYPE.REAL);
        for(int number : square){
            if(number != 0) {nonviables.add(number);}
        }
        return new ArrayList<>(nonviables);
    }
}
