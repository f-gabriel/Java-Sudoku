package OldSudoku.Enums;

public enum EVENTS {
    INPUT_ROW("Input row (1-9): "),
    INPUT_COLUMN("Input column (1-9): "),
    INPUT_VALUE("Input value between 1-9: "),
    WRONG_SUDOKU_INPUT("Input has to be integer between 1-9"),
    NEW_INPUT("please make new input: "),
    SPECIAL_INPUT_ERROR("If using special input, they need to be the same number as menu options"),
    TRYING_TO_CHANGE_START_VALUE("This number is start value"),
    TRYING_TO_CHANGE_REAL_VALUE("Can't change real value"),;


    private final String message;

    EVENTS(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
