package it.unibo.mvc;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    //private String current;

    private String nameFile;
    private String PATH = System.getProperty("user.home")+System.getProperty("file.separator")+nameFile;

    private void updatePath(){
        PATH = System.getProperty("user.home")+System.getProperty("file.separator")+nameFile;
    }

    public String setNameFile(String input){
        return this.nameFile = input;
    }

    public String getPath(){
        updatePath();
        return this.PATH;
    }

    @Override
    public void setNextString(String input) {
        try(final BufferedWriter w = new BufferedWriter(new FileWriter(this.PATH))) {
            w.write(input);
            w.newLine();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    @Override
    public String nexString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nexString'");
    }

    @Override
    public ArrayList<String> history() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'history'");
    }

    @Override
    public void currentString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'currentString'");
    }

}
