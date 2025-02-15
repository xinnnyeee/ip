package ekko.storage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import ekko.task.Todolist;

/**
 * Handles the creation of directory and file, writing and updating the file.
 */
public class Storage {

    private String dirPath;
    private String filePath;

    public Storage() {
        this.dirPath = makeDir();
        this.filePath = createFile("ekko.txt");
    }

    /**
     * Creates a directory named "data" in the project folder if it does not exist.
     * @return the path to the created directory.
     */
    private String makeDir() {
        String projPath = System.getProperty("user.dir");
        String dirPath = projPath + File.separator + "data";
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return dirPath;
    }

    /**
     * Creates a file in the directory if it does not exist.
     * @param fileName name of the file.
     * @return the path to the created file.
     */
    private String createFile(String fileName) {
        String filePath = dirPath + File.separator + fileName;
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
        return filePath;
    }

    /**
     * Updates the file in this storage to sync it with the current todolist.
     * @param todolist current todolist to sync.
     */
    public void updateFile(Todolist todolist) {
        if (filePath == null) {
            System.out.println("Error: File path is not initialized.");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(todolist.toString());
        } catch (IOException e) {
            System.out.println("Uh oh, something went wrong when trying to write into a file.");
        }
    }
}
