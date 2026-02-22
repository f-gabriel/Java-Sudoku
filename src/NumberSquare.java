import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSquare {
    static final int[] allowed_numbers = {1,2,3,4,5,6,7,8,9};

    private final int row;
    private final int column;
    private final int square;
    private int value;
    private int input_value;

    NumberSquare(int row, int column){
        this.row = row;
        this.column = column;
        this.square = findSquareNumber();
        this.value = 0;
    }

    NumberSquare(int row, int column, List<Integer> nonViableNumbers){
        this.row = row;
        this.column = column;
        this.square = findSquareNumber();
        assignValue(nonViableNumbers);
    }

    NumberSquare(int row, int column, int value){
        this.row = row;
        this.column = column;
        this.square = findSquareNumber();
        this.value = value;
    }

    private int findSquareNumber(){

        return ((row % 3)+1) * ((column % 3) +1) -1;
    }

    public int getRowNumber() {
        return row;
    }
    public int getColumnNumber() {
        return column;
    }
    public int getSquareNumber() {
        return square;
    }
    public int getValue() {
        return value;
    }
    public int getInputValue() {
        return input_value;
    }
    public void setInputValue(int input_value){
        this.input_value = input_value;
    }


    void assignValue(List<Integer> nonViableNumbers){
        if (value == 0){
            List<Integer> viableNumbers = getViableNumbers(nonViableNumbers);

            this.value = getRandomViableNumber(viableNumbers);
        }
    }

    private List<Integer> getViableNumbers(List<Integer> nonViableNumbers){
        ArrayList<Integer> viableNumbers = new ArrayList<>();
        for(int number : allowed_numbers){
            if(nonViableNumbers.contains(number)){
                continue;
            }
            viableNumbers.add(number);
        }
        return viableNumbers;
    }

    private int getRandomViableNumber(List<Integer> viableNumbers){
        Random r = new Random();

        System.out.println(viableNumbers);
        int randomIndexViableNumbers = r.nextInt(viableNumbers.size());
        return viableNumbers.get(randomIndexViableNumbers);
    }


}
