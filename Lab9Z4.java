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
        int i = 0;
        while (i < dlugosc) {
            System.out.print("-");
            i++;
        }
        System.out.println();
    }
}

class Kwadrat extends Figura {
    public Kwadrat(int dlugosc) {
        super(dlugosc);
    }

    public void rysuj() {
        System.out.println("Rysowanie kwadratu o boku: " + dlugosc);
        int i = 0;
        while (i < dlugosc) {
            int j = 0;
            while (j < dlugosc) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
public class Lab9Z4 {
    public static void test(Figura figura) {
        figura.rysuj();
        Class<?> c = figura.getClass();
        if (c==Kwadrat.class) {
            int pole = ((Kwadrat)figura).dlugosc * ((Kwadrat)figura).dlugosc;
            System.out.println("Pole kwadratu: " + pole);
        }
    }
    public static void main(String[] args) {
        Linia lin1 = new Linia(5);
        Kwadrat kw1 = new Kwadrat(5);

        Random rand = new Random();
        int randomNumber = rand.nextInt();
        System.out.println("Wylosowana liczba: " + randomNumber);
        if (randomNumber % 2 == 0) {
            test(lin1);
        } else {
            test(kw1);
        }
    } 
}
