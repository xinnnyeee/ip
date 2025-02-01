import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handle the creation of directory and file, writing and updating the file
 */
public class Storage {

    public String dirPath;

    public Storage() {
        this.dirPath = makeDir();
    }

    /**
     * Making a directory in the project folder called "data".
     * @return the path to the directory created
     */
    public String makeDir() {
        String projPath = System.getProperty("user.dir");
        String dirPath = projPath + File.separator + "data";
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return dirPath;
    }

    /**
     * Create a file in the directory created.
     * @param fileName name of the file
     * @return path to the file created
     */
    public String createFile(String fileName) {
        String filePath = dirPath + File.separator + fileName;
        File file = new File(filePath);
        return filePath;
    }

    /**
     * Update the file to sync it with the current todolist.
     * @param filePath path to the destination file
     * @param todolist current todolist to sync
     */
    public void updateFile(String filePath, Todolist todolist) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(todolist.toString());
        } catch (IOException e) {
            System.out.println("Uh oh, something went wrong when trying to create a file.");
        }
    }
}