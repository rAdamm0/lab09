package it.unibo.mvc;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;


/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private String fName = "output.txt";
    private  String PATH = System.getProperty("user.home") + 
    System.getProperty("file.separator") + fName;

    public String setFile(String nameFile){
       return this.fName = nameFile;
    }

    public String getFile(){
        return this.fName;
    }

    public String getPATH(){
        return this.PATH;
    }

    public void saveString(String input){
        try (PrintStream is = new PrintStream(this.PATH, StandardCharsets.UTF_8)){
            is.print(input);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
