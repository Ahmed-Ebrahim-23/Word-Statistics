package GUI;

import static GUI.FrameGUI.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class TopPanel extends JFrame{

    public JTextField directoryName;    
    public JTextField directoryPath;
    private String selectedFolderPath = "Documents";
    
    public TopPanel() {
        createTopPanel();
        pack();
        setLocationRelativeTo(null);
    }
    
    public void createTopPanel() {
        JPanel topPanel = new JPanel(new GridLayout(3,0));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.setBackground(Color.red);

        // Create a checkbox
        JCheckBox selectDirectoryCheckBox = new JCheckBox("Include subdirectory");
        selectDirectoryCheckBox.setBounds(7, 7, 7, 7);
        
        // Create textfield for directory name
        directoryName = new JTextField("File Name: ");
        directoryName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        directoryName.setEditable(false);
        
        // Create textfield for directory path
        directoryPath = new JTextField("File Path: ");
        directoryPath.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        directoryPath.setEditable(false);
        
        // Create button
        JButton browseButton = new JButton("Browse");
        browseButton.setBorderPainted(false);
        
        // Add the items to the topPanel
        JPanel row1 = new JPanel(new BorderLayout());
        row1.add(directoryName, BorderLayout.CENTER);
        row1.add(browseButton, BorderLayout.EAST);
        
        JPanel row2 = new JPanel(new BorderLayout());
        row2.add(directoryPath);
        
        JPanel row3 = new JPanel(new BorderLayout());
        row3.add(selectDirectoryCheckBox);

        topPanel.add(row1);
        topPanel.add(row2);
        topPanel.add(row3);

        // Add TopPanel to GUI
        Frame.add(topPanel, BorderLayout.NORTH);
        
        
        browseButton.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int option = fileChooser.showOpenDialog(TopPanel.this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = fileChooser.getSelectedFile();
                directoryName.setText(directoryName.getText() + selectedDirectory.getName());  
                directoryPath.setText(directoryPath.getText() +selectedDirectory.getAbsolutePath());
                
                // Check if the checkbox is selected
                boolean includeSubdirectories = selectDirectoryCheckBox.isSelected();
                analyzeFiles(selectedDirectory, includeSubdirectories);
            }
        });
    }
    private void analyzeFiles(File directory, boolean includeSubdirectories) {
        if (directory == null || !directory.isDirectory()) {
            JOptionPane.showMessageDialog(this, "Please select a valid directory.", "Invalid Directory",
                    JOptionPane.ERROR_MESSAGE);
            return;
        } 
    }
    
}