package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private final String USER_HOME = System.getProperty("user.home");
    private final String SEPARATOR = System.getProperty("file.separator");
    private File file = new File(USER_HOME + SEPARATOR + "output.txt");

    public void setFile(String fileName) {
        this.file = new File(USER_HOME + SEPARATOR + fileName);
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public String getPath() {
        return this.file.getAbsolutePath();
    }

    public void writeToFile(String messaage) {
        try (PrintStream ps = new PrintStream(file)) {
            ps.println(messaage);
        } catch (final IOException e) {
            System.out.println("The writeToFile didnt complete, here is the error: " + e.getMessage());
        }
    }

}
