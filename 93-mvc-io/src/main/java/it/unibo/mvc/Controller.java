package it.unibo.mvc;

import java.util.ArrayList;

/**
 *
 */
public interface Controller {

    public boolean setNextString(String input);

    public String nexString();

    public ArrayList<String> history();

    public void currentString();

}
