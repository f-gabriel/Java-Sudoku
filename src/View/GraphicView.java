package View;

import javax.swing.*;
import java.awt.*;

public class GraphicView {
    private JFrame frame;
    private JPanel panel;

    public GraphicView(){
        initialize();
    }

    private void initialize() {
        initializePanel();
        initializeFrame();

    }

    private void initializePanel() {
        this.panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        //String numberName = String.valueOf(1);
        //JButton button = new JButton(numberName);
        // panel.add(button);
        initializeButtons();


    }

    private void initializeButtons() {
        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 8; j++){

                String numberName = String.valueOf(j+1);
                JButton button = new JButton(numberName);
                panel.add(button);

            }
        }
    }

    private void initializeFrame() {
        this.frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(panel);

        frame.setVisible(true);
    }
}
