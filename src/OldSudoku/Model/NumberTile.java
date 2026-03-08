package OldSudoku.Model;

import OldSudoku.Enums.EVENTS;
import OldSudoku.Enums.VALUETYPE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberTile {
    public static final int[] allowedNumbers = {1,2,3,4,5,6,7,8,9};

    public final int row;
    public final int column;
    public final int square;
    private int realValue;
    private int inputValue; // vill ha detta som en lista sedan.
    private boolean inputValueIsStartValue = false;

    public NumberTile(int row, int column){
        this.row = row;
        this.column = column;
        this.square = findSquareNumber();
        this.realValue = 0;
        this.inputValue = 0;
    }

    public NumberTile(NumberTile nt){
        this.row = nt.row;
        this.column = nt.column;
        this.square = findSquareNumber();
        this.realValue = nt.realValue;
        this.inputValue = nt.inputValue;
        this.inputValueIsStartValue = nt.inputValueIsStartValue;
    }

    public NumberTile(int row, int column, List<Integer> nonViableNumbers){
        this.row = row;
        this.column = column;
        this.square = findSquareNumber();
        assignRealValue(nonViableNumbers);
    }

    public NumberTile(int row, int column, int realValue){
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
    public boolean getIsStartValue(){return inputValueIsStartValue;}
    public void setInputValue(int input_value){
        if(!inputValueIsStartValue){
            this.inputValue = input_value;
        } else {
            System.out.println(EVENTS.TRYING_TO_CHANGE_START_VALUE.getMessage());
        }
    }

    public void setToStartValue(){
        this.inputValue = realValue;
        this.inputValueIsStartValue = true;
    }

    public int getValueOfType(VALUETYPE value){
        return switch (value) {
            case REAL -> getRealValue();
            case INPUT -> getInputValue();
        };
    }

    public void assignValueOfType(VALUETYPE value, List<Integer> nonViableNumbers){
        switch (value) {
            case REAL -> assignRealValue(nonViableNumbers);
            case INPUT -> {
                if (realValue == 0 ) {
                    List<Integer> viableNumbers = getViableNumbers(nonViableNumbers);
                    int randInputValue = getRandomViableNumber(viableNumbers);
                    setInputValue(randInputValue);
                }
            }
        };
    }

    public void assignRealValue(List<Integer> nonViableNumbers){
        if (realValue == 0 ){
            List<Integer> viableNumbers = getViableNumbers(nonViableNumbers);
            this.realValue = getRandomViableNumber(viableNumbers);}
        else{
            System.out.println(EVENTS.TRYING_TO_CHANGE_REAL_VALUE.getMessage());
        }
    }

    public static int[] getAllowedNumbers(){
        return allowedNumbers;
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
