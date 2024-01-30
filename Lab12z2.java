import java.io.*;

class Obywatel implements Serializable {
    private String nazwisko;
    private String imie;
    private String PESEL;
    private double dochod;

    public Obywatel() {
    }

    public Obywatel(String nazwisko, String imie, String PESEL, double dochod) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.PESEL = PESEL;
        this.dochod = dochod;
    }

    public void podajDane(String nazwisko, String imie, String PESEL, double dochod) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.PESEL = PESEL;
        this.dochod = dochod;
    }

    public void drukujDane() {
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Imię: " + imie);
        System.out.println("PESEL: " + PESEL);
        System.out.println("Dochód: " + dochod);
    }
}

public class Lab12z2 {
    public static void main(String[] args) {
        Obywatel obywatel1 = new Obywatel("Kowalski", "Jan", "1234567890", 5000.0);
        Obywatel obywatel2 = new Obywatel();

        obywatel2.podajDane("Nowak", "Anna", "0987654321", 6000.0);

        try {
            FileOutputStream fileOut = new FileOutputStream("obywatelser1.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(obywatel1);
            objectOut.writeObject(obywatel2);
            objectOut.close();
            fileOut.close();
            System.out.println("Serializacja zakończona.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileIn = new FileInputStream("obywatelser1.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Obywatel obywatel3 = (Obywatel) objectIn.readObject();
            Obywatel obywatel4 = (Obywatel) objectIn.readObject();
            objectIn.close();
            fileIn.close();

            System.out.println("Odczytane dane:");
            obywatel3.drukujDane();
            obywatel4.drukujDane();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
