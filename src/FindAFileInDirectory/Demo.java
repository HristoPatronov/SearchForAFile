package FindAFileInDirectory;

import java.io.File;
import java.util.Objects;

public class Demo {

    public static void main(String[] args) {
        System.out.println(exists("C:\\Users\\Ico\\Desktop", "ico.txt"));
    }

    private static boolean exists(String directory, String file) {
        File f = new File(directory + "\\" + file);
        File dir = new File(directory);

        if (dir.isDirectory()) {
            for (File currentFile : Objects.requireNonNull(dir.listFiles())) {
                if (currentFile.isDirectory()) {
                    boolean found = exists(currentFile.getAbsolutePath(), file);
                    if (found) {
                        return true;
                    }
                } else {
                    if (f.exists()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
