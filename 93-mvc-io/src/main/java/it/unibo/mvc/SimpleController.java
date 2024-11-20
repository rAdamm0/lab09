package it.unibo.mvc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String current;

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
        try(PrintStream ps = new PrintStream(this.PATH, StandardCharsets.UTF_8)) {
            ps.append(input);
        } catch (IOException e) {
            e.getStackTrace();
            System.err.println("ERROR in setNextString");
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
