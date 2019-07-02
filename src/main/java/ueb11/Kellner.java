package ueb11;

public class Kellner implements Runnable {
    private String name;
    private int anzahlSpeisen;
    private Durchreiche durchreiche;

    public Kellner(){
        this.name = "";
        this.anzahlSpeisen = 0;
        this.durchreiche = null;
    }

    public Kellner(String name){
        this();
        this.name = name;
    }

    public Kellner(String name, int anzahlSpeisen, Durchreiche durchreiche){
        this.name = name;
        this.anzahlSpeisen = anzahlSpeisen;
        this.durchreiche = durchreiche;
    }

    public String getName(){
        return this.name;
    }


    @Override
    public void run() {
        try{
            Thread.sleep((int) (Math.random() * 10000));
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < anzahlSpeisen; i++) {
            System.out.println(getName() + " entnimmt Speise " + durchreiche.get() + "(" + i + ")");
            // getName() + " hat Essen " + i + "()" +" aus der Durchreiche genommen"
        }
    }
}
