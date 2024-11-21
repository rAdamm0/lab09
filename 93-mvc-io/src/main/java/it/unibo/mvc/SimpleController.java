package it.unibo.mvc;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final ArrayList<String> his = new ArrayList<>();

    //private String current;

    private String nameFile = "output.txt";
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
            his.add(input);
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
        return his;
    }

    @Override
    public String currentString() {
        if(!his.isEmpty()){
           String m = his.getLast().toString();
           return m;
        }else{
            throw new IllegalStateException("No history detected");
        }
    }

}
