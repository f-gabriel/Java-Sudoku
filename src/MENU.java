public enum MENU {
    START("New Game"),
    MENU("Menu"),
    SOLVE("Solve Sudoku"),
    HELP("Help"),
    INSTRUCTIONS("Instructions"),
    CREDITS("Credits"),
    END("Exit");

    final String message;

    private MENU(String message){
    this.message = message;
    }

    public String getMessage(){return this.message;}
}
