package GUI;

import javax.swing.*;

public class FrameGUI extends JFrame{
    static JPanel panel = new JPanel();
    static JFrame Frame = new JFrame(); 
    ImageIcon icon = new ImageIcon(getClass().getResource("/Icon/icon.png"));
    
    // Constructor of the GUI that add it's properties 
    public FrameGUI() {
        Frame.setTitle("Word Statistics");
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the Frame Full Screen
        Frame.setIconImage(icon.getImage());
        
        TopPanel top = new TopPanel();
        
        ShowGUI();
    }
    
    // function to show the gui after adding all components
    public void ShowGUI(){
        Frame.add(panel);
        Frame.setVisible(true);
    }
}