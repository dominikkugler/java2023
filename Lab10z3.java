abstract class Wolumin {
    protected int id;

    public Wolumin() {
        // Automatyczne przypisanie kolejnego numeru do pola id
        id = generateNextId();
    }

    private static int nextId = 1;

    private static int generateNextId() {
        return nextId++;
    }
}

class Ksiazka extends Wolumin {
    private String tytul;
    private String autor;

    public Ksiazka(String tytul, String autor) {
        this.tytul = tytul;
        this.autor = autor;
    }
}

class Czasopismo extends Wolumin {
    private String tytul;
    private int numerWydania;

    public Czasopismo(String tytul, int numerWydania) {
        this.tytul = tytul;
        this.numerWydania = numerWydania;
    }
}

public class Lab10z3 {
    public static void main(String[] args) {
        Ksiazka ksiazka = new Ksiazka("Tytul ksiazki", "Autor ksiazki");
        Czasopismo czasopismo = new Czasopismo("Tytul czasopisma", 1);

        Wolumin[] tabObj = new Wolumin[2];
        tabObj[0] = ksiazka;
        tabObj[1] = czasopismo;
    }
}
