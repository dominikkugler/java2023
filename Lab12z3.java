import java.io.*;

class Obywatel implements Externalizable {
    private String imie;
    private String nazwisko;
    private int wiek;

    public Obywatel() {
        // Default constructor required for deserialization
    }

    public Obywatel(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(imie);
        out.writeObject(nazwisko);
        out.writeInt(wiek);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        imie = (String) in.readObject();
        nazwisko = (String) in.readObject();
        wiek = in.readInt();
    }

    @Override
    public String toString() {
        return "Obywatel{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}

public class Lab12z3 {
    public static void main(String[] args) {
        Obywatel obywatel1 = new Obywatel("Jan", "Kowalski", 30);
        Obywatel obywatel2 = new Obywatel("Anna", "Nowak", 25);

        try {
            // Serializacja
            FileOutputStream fileOut = new FileOutputStream("obywatelser2.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obywatel1);
            out.writeObject(obywatel2);
            out.close();
            fileOut.close();

            // Deserializacja
            FileInputStream fileIn = new FileInputStream("obywatelser2.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Obywatel obywatelDeserialized1 = (Obywatel) in.readObject();
            Obywatel obywatelDeserialized2 = (Obywatel) in.readObject();
            in.close();
            fileIn.close();

            // Wydruk odczytanych danych
            System.out.println("Odczytane dane:");
            System.out.println(obywatelDeserialized1);
            System.out.println(obywatelDeserialized2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
