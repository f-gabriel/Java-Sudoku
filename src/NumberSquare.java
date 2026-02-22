public class NumberSquare {
    int row;
    int column;
    int square;
    int value;
    int input_value;

    NumberSquare(int row, int column){
        this.row = row;
        this.column = column;
        this.square = find_square();
        this.value = find_value();
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public int getSquare() {
        return square;
    }
    public int getValue() {
        return value;
    }
    public int getInput_value() {
        return input_value;
    }
    public void setInput_value(int input_value){
        this.input_value = input_value;
    }
    private int find_square(){
        return (row +1) * (column +1) -1;
    }
    private int find_value(){
        return 0;
    }
}
