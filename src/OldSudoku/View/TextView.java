package OldSudoku.View;

import OldSudoku.Enums.EVENTS;
import OldSudoku.Enums.MENU;

public class TextView {


    public TextView(){

    }






    private String menuBuilder(MENU[] menuOptions, String[] specialInputChars){
        if(menuOptions.length != specialInputChars.length && specialInputChars.length != 0){
            System.out.println(EVENTS.SPECIAL_INPUT_ERROR.getMessage());
            return"";
        }

        String[] inputChars;
        String[] menuLines = new String[menuOptions.length];
        StringBuilder returnString = new StringBuilder();
        if (specialInputChars.length != 0){inputChars = specialInputChars;}
        else{
            inputChars = new String[menuOptions.length];
            for (int i = 0; i < menuOptions.length; i++){
                inputChars[i] = "" + (i + 1);
            }
        }
        for(int i = 0; i < inputChars.length; i++){
            menuLines[i] = inputChars[i] + ") " + menuOptions[i].getMessage();
        }
        for (String menuLine : menuLines){
            returnString.append(menuLine).append("\n");
        }
        return returnString.toString();
    }


}
