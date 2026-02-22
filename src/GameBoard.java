public class GameBoard {
    int[][] gameBoard;

    GameBoard(){
        createGameBoard();

    }

    void createGameBoard(){
        this.gameBoard = new int[9][9];
        for(int[] row : gameBoard){
            for(int i = 1; i <= 9; i++){
                row[i-1] = i;
            }
        }
    }

    int[] get_row(int row_number){
        return gameBoard[row_number];
    }
    int[] get_column(int column_number){
        int[] column = new int[9];
        for(int i = 0; i <= 8; i++ ) {
            column[i] = gameBoard[i][column_number];
        }
        return column;
    }
    int[] get_square(int square_number){
        int[] square = new int[9];
        int column_number = square_number % 3;
        int row_number = (int) square_number / (column_number+1);
        for(int row = 0; row <= 2; row++){
            for(int column = 0; column <= 2; column++){
                int square_index = 3 * row + column;
                square[square_index] = gameBoard[row + row_number][column + column_number];
            }
        }
        return square;
    }

    public String toString(){
        StringBuilder returnString = new StringBuilder();
        for(int row = 0; row <= 8; row++) {
            returnString.append(rowToString(row));
        }
        return returnString.toString();
    }
    private String rowToString(int row){
        StringBuilder returnString = new StringBuilder();
        if(row != 0) {
            returnString.append("\n");
            if ((row) % 3 == 0) {
                returnString.append("_____________________\n");
            }
        }
        returnString.append(columnToString(row));
        return returnString.toString();
    }
    private String columnToString(int row){
        StringBuilder returnString = new StringBuilder();
        for (int place = 0; place <= 8; place++) {
            if (gameBoard[row][place] == 0) {
                returnString.append("_ ");
            } else {
                returnString.append(gameBoard[row][place] + " ");
            }
            if((place + 1) % 3 == 0 && place != 8){
                returnString.append("| ");
            }
        }
        return returnString.toString();
    }
}
