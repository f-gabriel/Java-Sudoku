package Control;

import Enums.EVENTS;

import java.util.Scanner;

public class PlayerTextInput {
    private final EVENTS[] inputVariables;
    private int[] playerInputInts;


    private final Scanner scanner;

    public PlayerTextInput(){
        this.inputVariables = new EVENTS[]{EVENTS.INPUT_ROW, EVENTS.INPUT_COLUMN, EVENTS.INPUT_VALUE};
        this.playerInputInts = new int[3];
        this.scanner = new Scanner(System.in);
    }

    public int[] getPlayerInput(){
        for(int i = 0; i <= 2; i++){
            String message = inputVariables[i].getMessage();
            System.out.println(message);
            String input = scanner.nextLine();

            int inputInt =  checkInput(input);
            if (i < 2) {
                inputInt--;
            }
            playerInputInts[i] = inputInt;
        }
        return playerInputInts;
    }

    private int checkInput(String input) {
        int inputInt = 0;
        while (inputInt == 0) {
            try {
                inputInt = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                input = badInputResponse();
            }
            if (1 > inputInt || inputInt > 9){
                input = badInputResponse();
                inputInt = 0;
            }
        }
        return inputInt;
    }

    private String badInputResponse(){
        System.out.println(EVENTS.WRONG_SUDOKU_INPUT.getMessage());
        System.out.println(EVENTS.NEW_INPUT.getMessage());
        return scanner.nextLine();
    }
}
