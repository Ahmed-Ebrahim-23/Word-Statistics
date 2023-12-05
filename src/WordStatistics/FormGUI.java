package WordStatistics;

import javax.swing.*;

public class FormGUI extends JFrame{
    public FormGUI() {
        JFrame Frame = new JFrame(); 
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icon/icon.png"));
        
        Frame.setTitle("Word Statistics");
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the Frame Full Screen
        Frame.setIconImage(icon.getImage());
        
        JPanel panel = new JPanel();
        Frame.add(panel);

        Frame.setVisible(true);
    }


    public static void main(String[] args) {
        FormGUI Frame  = new FormGUI();
    }
}