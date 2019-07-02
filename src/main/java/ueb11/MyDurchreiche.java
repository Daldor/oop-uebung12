package ueb11;

import java.util.LinkedList;

import java.util.Queue;

public class MyDurchreiche<T> implements Durchreiche<T> {
    final int stellplaetze;
    Queue<T> durchreiche = new LinkedList<>();


    public MyDurchreiche(int i){
        this.stellplaetze = i;
    }


    public synchronized T get() {
        //T ausgabe = durchreiche.remove();
        if(durchreiche.size() == 0){
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            notifyAll();
        }
        return durchreiche.remove();
    }

    public int getSize(){
        try{
            Thread.sleep((int) (Math.random() * 30000));
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return durchreiche.size();
    }

    @Override
    public synchronized void put(T o) {
        if (durchreiche.size() > stellplaetze) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            notifyAll();
        }
        durchreiche.add(o);
    }
}
