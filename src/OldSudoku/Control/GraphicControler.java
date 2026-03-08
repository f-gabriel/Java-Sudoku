package OldSudoku.Control;

import OldSudoku.Model.NumberTile;

import javax.swing.*;

public class GraphicControler {
    JFrame frame;

    JButton[][] buttons;

    public GraphicControler(){



    NumberTile nTile = new NumberTile(0,0,9);
    nTile.setToStartValue();
    SudokuButton sudokuButton = new SudokuButton(nTile);
    }
}
