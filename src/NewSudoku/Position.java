package NewSudoku;

public class Position {
    Row row;
    Column column;
    Square square;

    Position(Row row, Column column, Square square) {
        this.row = row;
        this.column = column;
        this.square =  square;
    }



    private static int findSquareNumber(int rowNumber, int columnNumber) {
        return (rowNumber * 3) + (columnNumber % 3);
    }
}
