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

public class Lab9z1 {
    public static void main(String[] args) {
        Figura[] figury = new Figura[4];
        figury[0] = new Linia(5);
        figury[1] = new Linia(8);
        figury[2] = new Kwadrat(4);
        figury[3] = new Kwadrat(6);

        for (Figura figura : figury) {
            figura.rysuj();
        }
    }
}
