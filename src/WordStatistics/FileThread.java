package WordStatistics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class FileThread implements Runnable{
    private Path filePath;
    private DefaultTableModel tableModel;
    private int rowIndex;
    private static int count;

    public FileThread(Path filePath, DefaultTableModel tableModel,int rowIndex) {
        this.filePath = filePath;
        this.tableModel = tableModel;
        this.rowIndex = rowIndex;
    }

    @Override
    public void run() {
        System.out.println("hey");
        try {
            processFile(filePath);
        } catch (IOException ex) {
            Logger.getLogger(FileThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int num_of_words =0;
    private int num_of_is=0;
    private int num_of_you=0;
    private int num_of_are=0;
    private int longestWordLength = Integer.MIN_VALUE;
    private int shortestWordLength = Integer.MAX_VALUE;

    private void processFile(Path filePath) throws IOException {
        
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))){
                String line;
                while((line = reader.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    for(String word : words){
                        if(word.isEmpty())
                            continue;
                        SwingUtilities.invokeLater(() -> {
                                    num_of_words++;
                                    tableModel.setValueAt(num_of_words, rowIndex, 1);
                                    if ("you".equalsIgnoreCase(word)) {
                                        num_of_you++;
                                        tableModel.setValueAt(num_of_you, rowIndex, 2);
                                    } 
                                    else if ("is".equalsIgnoreCase(word)) {
                                        num_of_is++;
                                        tableModel.setValueAt(num_of_is, rowIndex, 3);
                                    } 
                                    else if ("are".equalsIgnoreCase(word)) {
                                        num_of_are++;
                                        tableModel.setValueAt(num_of_are, rowIndex, 4);
                                    }
                               if (Character.isLetter(word.charAt(0))) {
                                    if (word.length() > longestWordLength) {
                                        longestWordLength = word.length();
                                        tableModel.setValueAt(word, rowIndex, 5);
                                    }
                                    if (word.length() < shortestWordLength && word.length()!=0) {
                                        shortestWordLength = word.length();
                                        tableModel.setValueAt(word, rowIndex, 6);
                                    }
                               }   
                        });
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileThread.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
    
                     /* Timer timer = new Timer(100, new ActionListener() {
                                              public void actionPerformed(ActionEvent e) {
                        
                        else
                        ((Timer) e.getSource()).stop();
                        });
                        }
                        
                        });
                        timer.start();*/
