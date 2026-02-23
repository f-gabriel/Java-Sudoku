import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GameBoard {
    NumberSquare[][] gameBoard;

    GameBoard(){
        createGameBoard();
    }

    NumberSquare getNumberSquareAtPos(int row, int column){
        return gameBoard[row][column];
    }

    public boolean isSolvable(){
        boolean isSolvable = true;
        for(NumberSquare[] row : gameBoard){
            if (!isSolvable){break;}
            for(NumberSquare nSquare : row){
                isSolvable = nSquare != null;
                if (!isSolvable){break;}
            }
        }
        return isSolvable;
    }

    void createGameBoard(){
        this.gameBoard = new NumberSquare[9][9];
        for(int row = 0; row <= 8; row++){
            for(int column = 0; column <= 8; column++){
                NumberSquare ns = new NumberSquare(row, column);
                List<Integer> nonAvailableNumbers = findNonAvailableNumbers(ns);
                if (nonAvailableNumbers.size() == 9){// todo remove
                    //System.out.println(nonAvailableNumbers);// todo remove
                    //System.out.println(toString());// todo remove
                    //createGameBoard();// todo remove
                    break;// todo remove
                }
                ns.assignValue(nonAvailableNumbers);
                gameBoard[row][column] = ns;
            }
        }
    }

    List<Integer> findNonAvailableNumbers(NumberSquare nSquare){
        LinkedHashSet<Integer> nonVialables = new LinkedHashSet<>();
        List<Integer> row = retrieveValuesFromNumberSquareList(get_row(nSquare));
        for(int number : row){
            if(number != 0){
                nonVialables.add(number);
            }
        }
        //System.out.println("row: "+row);// todo remove
        List<Integer> column = retrieveValuesFromNumberSquareList(get_column(nSquare));
        for(int number : column){
            if(number != 0){
                nonVialables.add(number);
            }
        }
        //System.out.println("column: "+column);// todo remove
        List<Integer> square = retrieveValuesFromNumberSquareList(get_square(nSquare));
        for(int number : square){
            if(number != 0){
                nonVialables.add(number);
            }
        }
        //System.out.println("square: "+square);// todo remove
        return setToList(nonVialables);
    }

    List<Integer> retrieveValuesFromNumberSquareList(NumberSquare[] nSquareList){
        ArrayList<Integer> values = new ArrayList<>();
        for(NumberSquare square : nSquareList){
            if(square != null){
                values.add(square.getValue());
            }
        }
        return values;
    }

    NumberSquare[] get_row(NumberSquare nSquare){
        return gameBoard[nSquare.getRowNumber()];
    }

    NumberSquare[] get_column(NumberSquare nSquare){
        NumberSquare[] column = new NumberSquare[9];
        for(int i = 0; i <= 8; i++ ) {
            column[i] = gameBoard[i][nSquare.getColumnNumber()];
        }
        return column;
    }

    NumberSquare[] get_square(NumberSquare nSquare){
        NumberSquare[] square = new NumberSquare[9];
        int squareNumber = nSquare.getSquareNumber();
        int column_number = 3 * (((squareNumber) % 3));
        int row_number = (squareNumber - (squareNumber % 3));


        //System.out.println("squareNumber = " + nSquare.getSquareNumber()); //todo remove
        //System.out.println(column_number +","+ row_number); //todo remove

        for(int row = 0; row <= 2; row++){
            for(int column = 0; column <= 2; column++){
                int square_index = 3 * row + column;
                square[square_index] = gameBoard[row + row_number][column + column_number];
            }
        }
        return square;
    }

    private List<Integer> setToList(Set<Integer> set){
        ArrayList<Integer> returnList = new ArrayList<>();
        returnList.addAll(set);
        return returnList;
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
        returnString.append("\n");
        if ((row) % 3 == 0) {
            returnString.append("_____________________\n");
        }

        returnString.append(columnToString(row));
        return returnString.toString();
    }
    private String columnToString(int row){
        StringBuilder returnString = new StringBuilder();
        for (int place = 0; place <= 8; place++) {
            if (gameBoard[row][place] == null || gameBoard[row][place].getValue() == 0) { // should be getInputValue()
                returnString.append("_ ");
            } else {
                returnString.append(gameBoard[row][place].getValue() + " ");
            }
            if((place + 1) % 3 == 0 && place != 8){
                returnString.append("| ");
            }
        }
        return returnString.toString();
    }
}
