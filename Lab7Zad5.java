import java.util.ArrayList;
import java.util.List;

class Książka {
    private int numer;

    Książka(int numer) {
        this.numer = numer;
    }

    int getNumer() {
        return numer;
    }
}

class Półka {
    private int pojemność;
    private List<Książka> książki;

    Półka(int pojemność) {
        this.pojemność = pojemność;
        this.książki = new ArrayList<>();
    }

    void dodajKsiążkę(Książka książka) {
        if (książki.size() < pojemność) {
            książki.add(książka);
            System.out.println("Dodano książkę o numerze: " + książka.getNumer());
        } else {
            System.out.println("Półka jest pełna. Nie dodano książki.");
        }
    }

    int ileKsiążek() {
        return książki.size();
    }
}

class Regał {
    private List<Półka> półki;

    Regał() {
        this.półki = new ArrayList<>();
    }

    void dodajPółkę(Półka półka) {
        półki.add(półka);
        System.out.println("Dodano półkę do regału.");
    }

    int ilePółek() {
        return półki.size();
    }
}

public class Lab7Zad5 {

    public static void main(String[] args) {
        Regał r = new Regał();
        r.dodajPółkę(new Półka(20));

        Półka p = new Półka(20);
        p.dodajKsiążkę(new Książka(1111));
        
        r.dodajPółkę(p);

        System.out.println("Liczba półek w regale: " + r.ilePółek());
        System.out.println("Liczba książek na półce: " + p.ileKsiążek());
    }
}
