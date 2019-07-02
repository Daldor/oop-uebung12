package ueb11;

public class Restaurant {



    public static void main(String[] args) {
        MyDurchreiche MD = new MyDurchreiche(10);
        Koch koch1 = new Koch("Marius", 5, MD);
        Koch koch2 = new Koch("Hans", 2, MD);
        Kellner kellner1 = new Kellner("Chris", 3, MD);
        Kellner kellner2 = new Kellner("Gisela", 2, MD);
        new Thread(koch1).start();
        new Thread(koch2).start();
        new Thread(kellner1).start();
        new Thread(kellner2).start();

        //System.out.println(MD.getSize());
    }
}
