import java.util.Random;

public class GameState implements IHasSudokuStringRepresentation{
    GameBoard gBoard;
    SudokuSolver solver;
    PlayerTextInput textInput;
    TextView textView;

    boolean playing;



    GameState(){
        this.solver = new SudokuSolver();
        this.gBoard = solver.solveSudoku(VALUETYPE.REAL);
        this.textInput = new PlayerTextInput();
        this.textView = new TextView();
        play();

    }


    private void createSudokuStartLayout(){
        Random r = new Random();
        int numberOfStartTiles = 17;

        for(int i = 0; i < numberOfStartTiles; i++){
            int randomRow = r.nextInt(0,8);
            int randomColumn = r.nextInt(0,8);

            NumberTile ns = gBoard.getNumberTileAtPos(randomRow, randomColumn);
            switch (gBoard.getSquarePosition(ns.getSquareNumber())){
                case MIDDLE: {
                    NumberTile ns2 = gBoard.getNumberTileAtPos(8- randomRow, randomColumn);
                    NumberTile ns3 = gBoard.getNumberTileAtPos(randomRow, 8- randomColumn);
                    NumberTile ns4 = gBoard.getNumberTileAtPos(8- randomRow, 8- randomColumn);
                    ns.setToStartValue();
                    ns2.setToStartValue();
                    ns3.setToStartValue();
                    ns4.setToStartValue();
                }
                case VERTICAL, HORIZONTAL, CORNER: {
                    NumberTile ns2 = gBoard.getNumberTileAtPos(8- randomRow, 8- randomColumn);
                    ns.setToStartValue();
                    ns2.setToStartValue();
                }
            }
        }
    }

    private void play(){
        this.playing = true;
        createSudokuStartLayout();

        while(playing){
            System.out.println("");
            System.out.println(toString());
            System.out.println("");

            int[] input = textInput.getPlayerInput();
            handlePlayerInput(input);

            ; // funkar inte i intellij
            clearConsole();
        }
    }

    private void handlePlayerInput(int[] playerInputs){
        gBoard.handlePlayerInput(playerInputs[0], playerInputs[1], playerInputs[2]);
    }

    public static void clearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        int[][] sudoku = gBoard.sudokuIntRepresentation(VALUETYPE.INPUT);
        SudokuStringRepresentation sr = new SudokuStringRepresentation(sudoku);
        return sr.toString();
    }
}
