import java.util.HashMap;

public class TextView {
    HashMap<String, String> eventMessages;

    public TextView(){
        createEventMessages();

    }

    // The final messages should be something like "1. New Game", "2. Menu"
    private void createEventMessages() {
        HashMap<String, String> em = new HashMap<>();
        em.put("start", "New Game"); // em.put("", "");
        em.put("menu", "Menu");
        em.put("help", "Help");
        em.put("solve", "Solve Sudoku");
        em.put("end", "Exit");

        this.eventMessages = em;
    }

    private String getEventMessage(String event){
        return eventMessages.get(event);
    }

    private String menuBuilder(MENU[] menuOptions, String[] specialInputChars){
        if(menuOptions.length != specialInputChars.length && specialInputChars.length != 0){
            System.out.println("If using special input, they need to be the same number as menu options");
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
