package it.unibo.mvc;

import java.util.List;

/**
 *
 */
interface Controller {
    /**
     * Method that prints the set message to StandardOutput
     * and saves it in memory
     * {
     * 
     * @throws IllegalStateException} if the setMessage is null
     * 
     */
    void printOUt();

    /**
     * Method that sets the message
     * 
     * {@param message} Message ready to be printed
     */
    void setMessage(String message);

    /**
     * 
     * @return the next {@link String} to be print
     */
    String getSetMessage();

    /**
     * Method to print every message that has been printed
     */
    List<String> getHistory();
}
