import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSquare implements IHasNumberSquare{
    static final int[] allowedNumbers = {1,2,3,4,5,6,7,8,9};

    private final int row;
    private final int column;
    private final int square;
    private int realValue;
    private int inputValue;
    private boolean inputValueIsStartValue = false;

    NumberSquare(int row, int column){
        this.row = row;
        this.column = column;
        this.square = findSquareNumber();
        this.realValue = 0;
    }

    public static int[] getAllowedNumbers(){
        return allowedNumbers;
    }
    NumberSquare(int row, int column, List<Integer> nonViableNumbers){
        this.row = row;
        this.column = column;
        this.square = findSquareNumber();
        assignValue(nonViableNumbers);
    }

    NumberSquare(int row, int column, int realValue){
        this.row = row;
        this.column = column;
        this.square = findSquareNumber();
        this.realValue = realValue;
    }


    private int findSquareNumber(){
        return 3 * ((row) /3) + ((column) / 3);
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
    public int getRealValue() {
        return realValue;
    }
    public int getInputValue() {
        return inputValue;
    }
    public void setInputValue(int input_value){
        if(!inputValueIsStartValue){
            this.inputValue = input_value;
        } else {
            System.out.println("This number is start value");
        }
    }

    public void setToStartValue(){
        this.inputValue = realValue;
        this.inputValueIsStartValue = true;
    }
    public int getValue(VALUETYPE value){
        return switch (value) {
            case REAL -> getRealValue();
            case INPUT -> getInputValue();
        };
    }

    void assignValue(List<Integer> nonViableNumbers){
        if (realValue == 0){
            List<Integer> viableNumbers = getViableNumbers(nonViableNumbers);
            this.realValue = getRandomViableNumber(viableNumbers);}
    }

    public List<Integer> getViableNumbers(List<Integer> nonViableNumbers){
        ArrayList<Integer> viableNumbers = new ArrayList<>();
        for(int number : allowedNumbers){
            if(nonViableNumbers.contains(number)) {continue;}
            viableNumbers.add(number);}
        return viableNumbers;
    }

    private int getRandomViableNumber(List<Integer> viableNumbers){
        Random r = new Random();
        int randomIndexViableNumbers = r.nextInt(viableNumbers.size());
        return viableNumbers.get(randomIndexViableNumbers);
    }


}
