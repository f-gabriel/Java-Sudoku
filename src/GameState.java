import java.util.Random;

public class GameState {
    GameBoard gBoard;
    SudokuSolver solver;

    GameState(){
        this.solver = new SudokuSolver();
        this.gBoard = solver.solveSudoku();
        createSudokuStartLayout();
    }




    private void createSudokuStartLayout(){
        Random r = new Random();
        int numberOfStartTiles = 17;

        for(int i = 0; i < numberOfStartTiles; i++){
            int randomRow = r.nextInt(0,8);
            int randomColumn = r.nextInt(0,8);

            NumberTile ns = gBoard.getNumberTileAtPos(randomRow, randomColumn);
            switch (gBoard.getSquarePosition(ns.getSquareNumber())){
                case MIDDLE: {
                    NumberTile ns2 = gBoard.getNumberTileAtPos(8- randomRow, randomColumn);
                    NumberTile ns3 = gBoard.getNumberTileAtPos(randomRow, 8- randomColumn);
                    NumberTile ns4 = gBoard.getNumberTileAtPos(8- randomRow, 8- randomColumn);
                    ns.setToStartValue();
                    ns2.setToStartValue();
                    ns3.setToStartValue();
                    ns4.setToStartValue();
                }
                case VERTICAL, HORIZONTAL, CORNER: {
                    NumberTile ns2 = gBoard.getNumberTileAtPos(8- randomRow, 8- randomColumn);
                    ns.setToStartValue();
                    ns2.setToStartValue();
                }
            }
        }
    }



    @Override
    public String toString() {
        int[][] sudoku = gBoard.sudokuIntRepresentation(VALUETYPE.INPUT);
        SudokuStringRepresentation sr = new SudokuStringRepresentation(sudoku);
        return sr.toString();
    }
}
