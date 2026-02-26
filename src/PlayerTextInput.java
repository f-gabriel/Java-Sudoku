import java.util.Scanner;

public class PlayerTextInput {
    private final String inputMessage;
    private final String[] inputVariables;
    private int[] playerInputInts;

    private final Scanner scanner;

    PlayerTextInput(){
        this.inputMessage = "Input ";
        this.inputVariables = new String[]{"row (1-9): ", "column(1-9): ", "value between 1-9: "};
        this.playerInputInts = new int[3];
        this.scanner = new Scanner(System.in);
    }

    public int[] getPlayerInput(){
        for(int i = 0; i <= 2; i++){
            String message = inputMessage + inputVariables[i];
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
        System.out.println("Input has to be integer between 1-9");
        System.out.println("please make new input");
        return scanner.nextLine();
    }
}
