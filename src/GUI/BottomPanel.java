package GUI;

import static WordStatistics.Files.getFiles;
import static GUI.TopPanel.*;
import java.io.File;

public class BottomPanel {
    //note : after creating the panel add it to the frame
    public BottomPanel() {
        File[] Files = getFiles(Directory,Subdirectories);
    }
}
