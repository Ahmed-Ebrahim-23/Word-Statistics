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

    private Map<String, Integer> wordCount = new HashMap<>();
    private int longestWordLength = Integer.MIN_VALUE;
    private int shortestWordLength = Integer.MAX_VALUE;

    private void processFile(Path filePath) throws IOException {
        
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))){
                String line;
                if((line = reader.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    for(String word : words){
                        SwingUtilities.invokeLater(() -> {
                                if(count<words.length){
                                    if ("you".equalsIgnoreCase(word)) {
                                        wordCount.merge("you", 1, Integer::sum);
                                        tableModel.setValueAt(wordCount.get("you"), rowIndex, 1);
                                    } 
                                    else if ("is".equalsIgnoreCase(word)) {
                                        wordCount.merge("is", 1, Integer::sum);
                                        tableModel.setValueAt(wordCount.get("is"), rowIndex, 2);
                                    } 
                                    else if ("are".equalsIgnoreCase(word)) {
                                        wordCount.merge("are", 1, Integer::sum);
                                        tableModel.setValueAt(wordCount.get("are"), rowIndex, 3);
                                    }

                                    if (word.length() > longestWordLength) {
                                        longestWordLength = word.length();
                                    }
                                    if (word.length() < shortestWordLength) {
                                        shortestWordLength = word.length();
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
