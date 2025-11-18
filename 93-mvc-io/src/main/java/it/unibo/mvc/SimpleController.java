package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public final class SimpleController implements Controller {
    private final List<String> history = new ArrayList<>();
    private String tempMessage = null;

    @Override
    public void printOUt() {
        if (tempMessage == null) {
            throw new IllegalStateException("The setMessage is null");
        }
        System.out.println(tempMessage);
        history.add(tempMessage);
        tempMessage = null;
    }

    @Override
    public void setMessage(final String message) {
        this.tempMessage = message;
    }

    @Override
    public String getSetMessage() {
        return this.tempMessage;
    }

    @Override
    public List<String> getHistory() {
        return this.history;
    }
}
