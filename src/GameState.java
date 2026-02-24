import java.util.Random;

public class GameState {
    GameBoard gBoard;

    GameState(){
        this.gBoard = new GameBoard();
        createSudokuView();
    }

    private void createSudokuView(){
        Random r = new Random();
        int preWrittenSquares = 7;

        for(int i = 0; i < preWrittenSquares; i++){
            int randomRow = r.nextInt(0,8);
            int randomColumn = r.nextInt(0,8);

            NumberTile ns = gBoard.getNumberTileAtPos(randomRow, randomColumn);
            switch (getSquarePosition(ns.getSquareNumber())){
                case CORNER, MIDDLE: {
                    NumberTile ns2 = gBoard.getNumberTileAtPos(8- randomRow, randomColumn);
                    NumberTile ns3 = gBoard.getNumberTileAtPos(randomRow, 8- randomColumn);
                    NumberTile ns4 = gBoard.getNumberTileAtPos(8- randomRow, 8- randomColumn);
                    ns.setToStartValue();
                    ns2.setToStartValue();
                    ns3.setToStartValue();
                    ns4.setToStartValue();
                }
                case VERTICAL, HORIZONTAL: {
                    NumberTile ns2 = gBoard.getNumberTileAtPos(8- randomRow, 8- randomColumn);
                    ns.setToStartValue();
                    ns2.setToStartValue();
                }
            }
        }
    }

    private SquarePosition getSquarePosition(int squareNumber){
        return switch (squareNumber){
            case 0, 2, 6, 8 -> SquarePosition.CORNER;
            case 1, 7 -> SquarePosition.VERTICAL;
            case 3, 5 -> SquarePosition.HORIZONTAL;
            case 4 -> SquarePosition.MIDDLE;
            default -> throw new IllegalStateException("Unexpected value: " + squareNumber);
        };
    }

    @Override
    public String toString() {
        int[][] sudoku = gBoard.sudokuIntRepresentation(VALUETYPE.INPUT);
        SudokuStringRepresentation sr = new SudokuStringRepresentation(sudoku);
        return sr.toString();
    }
}
