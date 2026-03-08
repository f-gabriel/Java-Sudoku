package OldSudoku.View;

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
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        for(int i = 0; i<= 8; i++){
            initializeThreeSquarePanel();
        }

    }

    private void initializeThreeSquarePanel(){
        JPanel threeSquarePanel = new JPanel();
        threeSquarePanel.setBackground(Color.WHITE);
        threeSquarePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        threeSquarePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        initializeButtons(threeSquarePanel);

        panel.add(threeSquarePanel);
    }

    private void initializeButtons(JPanel threeSquarePanel) {
        for(int i = 0; i <= 2; i++){
            JPanel threeRowPanel = new JPanel();
            threeRowPanel.setBackground(Color.WHITE);
            threeRowPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

            for(int j = 0; j <= 2; j++){
                String numberName = String.valueOf(i * 3 + j + 1);
                JButton button = new JButton(numberName);
                threeRowPanel.add(button);
            }
            threeSquarePanel.add(threeRowPanel);
        }
    }

    private void initializeFrame() {
        this.frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(panel);

        frame.setVisible(true);
    }
}
