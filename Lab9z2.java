import java.util.Scanner;
abstract class FiguraN {
    protected int dlugosc;
    public abstract void rysuj();
}
class LiniaN extends FiguraN {
    public LiniaN(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public void rysuj() {
        System.out.println("Rysowanie linii o długości: " + dlugosc);
    }
}
class KwadratN extends FiguraN {
    public KwadratN(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public void rysuj() {
        System.out.println("Rysowanie kwadratu o boku: " + dlugosc);
    }
}
public class Lab9z2 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dlugosc = -1;   
        while (dlugosc <= 0) {    
            System.out.println("Podaj długość: ");
            dlugosc = sc.nextInt();
        }
        int choice = -1;
        while (choice!=1 && choice!=2) {
            System.out.println("Wybierz co narysowac: ");
            System.out.println("1. Linia");
            System.out.println("2. Kwadrat");
            choice = sc.nextInt();
        }
        switch (choice) {
            case 1:
                LiniaN linia = new LiniaN(dlugosc);
                linia.rysuj();
                break;
            case 2:
                KwadratN kwadrat = new KwadratN(dlugosc);
                kwadrat.rysuj();
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
                break;
        }
        sc.close();
    }
}