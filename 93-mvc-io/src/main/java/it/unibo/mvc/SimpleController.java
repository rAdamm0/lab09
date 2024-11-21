package it.unibo.mvc;

import java.util.ArrayList;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final ArrayList<String> his = new ArrayList<>();

    private String next;

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
