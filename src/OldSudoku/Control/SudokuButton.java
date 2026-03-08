package OldSudoku.Control;

import OldSudoku.Model.NumberTile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuButton {

    NumberTile nTile;
    JButton button;

    public SudokuButton(NumberTile nTile){
        this.nTile = nTile;
        this.button = new JButton(String.valueOf(nTile.getInputValue()));
    }

    public void initButton(){
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });
    }
}
