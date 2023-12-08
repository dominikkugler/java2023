import java.util.Random;

class Figura {
    protected int dlugosc;
    public Figura(int dlugosc) {
        this.dlugosc = dlugosc;
    }
    public void rysuj() {
        System.out.println("Rysowanie figury");
    }
}
class Linia extends Figura {
    public Linia(int dlugosc) {
        super(dlugosc);
    }

    public void rysuj() {
        System.out.println("Rysowanie linii o długości: " + dlugosc);
    }
}

class Kwadrat extends Figura {
    public Kwadrat(int dlugosc) {
        super(dlugosc);
    }

    public void rysuj() {
        System.out.println("Rysowanie kwadratu o boku: " + dlugosc);
    }
}
public class Lab9z3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = rand.nextInt();
        System.out.println("Wylosowana liczba: " + randomNumber);
        Figura figura;
        if (randomNumber % 2 == 0) {
            figura = new Linia(5);
        } else {
            figura = new Kwadrat(5);
        }

        Class<?> c = figura.getClass();
        System.out.println(c.getName());
    }
}