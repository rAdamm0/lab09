package it.unibo.mvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import javax.swing.JOptionPane;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private String fName = "output.txt";
    private  String PATH = System.getProperty("user.home") + 
    System.getProperty("file separator") + fName;

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
        try (PrintStream is = new PrintStream(this.PATH)){
            is.print(input);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
