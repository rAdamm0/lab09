package it.unibo.mvc;

import java.util.ArrayList;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final ArrayList<String> his = new ArrayList<>();

    private String next;

    @Override
    public boolean setNextString(String input) {
        this.next = input;
        if(this.next.equals(null)){
            throw new IllegalStateException();
        }
        return true;
    }

    @Override
    public String nexString() {
        if(this.next!=null){
            return this.next;
        }
        throw new IllegalStateException();
    }

    @Override
    public ArrayList<String> history() {
        ArrayList<String> temp=new ArrayList<>();
        temp.addAll(his);
        return temp;
    }

    @Override
    public void currentString() {
        if(this.next != null){
            his.add(this.next);
            System.out.println(this.next);
        } else {
            throw new IllegalStateException();
        }
    }

}
