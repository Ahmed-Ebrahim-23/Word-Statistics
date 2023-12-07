package WordStatistics;

import java.util.ArrayList;
import java.io.File;

public class Files{
    // getfiles function
    // input (URL location -> the location of the dirctory , boolean IncludeSubdirctories -> 0: false 1: true)
    // output (array of File with location and name)
    public static File[] getFiles(File directory, boolean includeSubdirectories) {
        File[] files = directory.listFiles();
        ArrayList<File> txtFiles = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) 
                    txtFiles.add(file); 
                else if (file.isDirectory() && includeSubdirectories == true) 
                    // Recursively analyze subdirectories
                    getFiles(file, false);
            }
        }
        return (txtFiles.isEmpty()? null : (File[]) txtFiles.toArray(File[]::new));
    }
}
