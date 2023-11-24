import java.util.Scanner;

class Kierownica {
    private boolean zablokowana = false;

    Kierownica() {
    }

    boolean kręćWLewo() {
        return !zablokowana;
    }

    boolean kręćWPrawo() {
        return !zablokowana;
    }

    void zablokuj() {
        zablokowana = true;
        System.out.println("Kierownica zablokowana.");
    }

    void odblokuj() {
        zablokowana = false;
        System.out.println("Kierownica odblokowana.");
    }

    @Override
    public String toString() {
        return "Kierownica { zablokowana=" + zablokowana + " }";
    }
}

class Samochod_2 {
    private int koła;
    private int siedzenia;
    private Kierownica kierownica;

    Samochod_2(int koła, int siedzenia) {
        this.koła = koła;
        this.siedzenia = siedzenia;
        this.kierownica = new Kierownica();
    }

    Kierownica getKierownica() {
        return kierownica;
    }

    boolean startuj() {
        System.out.println("Samochód startuje.");
        return true;
    }

    void przyspiesz() {
        System.out.println("Samochód przyspiesza.");
    }

    void hamuj(int jak) {
        System.out.println("Samochód hamuje z siłą: " + jak);
    }
}
public class Samochod {

    public static void main(String[] args) {
        Samochod_2 samochod = new Samochod_2(4, 5);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Sterowanie samochodem:");
            System.out.println("W - przyspiesz, S - zwolnij, D - skręć w prawo, A - skręć w lewo, SPACE - blokuj/odblokuj kierownicę, Q - wyjście");

            char wybor = scanner.next().charAt(0);

            switch (wybor) {
                case 'W':
                    samochod.przyspiesz();
                    break;
                case 'S':
                    samochod.hamuj(20); // przykładowa siła hamowania
                    break;
                case 'D':
                    boolean czySkręconoWPrawo = samochod.getKierownica().kręćWPrawo();
                    System.out.println("Czy skręcono w prawo: " + czySkręconoWPrawo);
                    break;
                case 'A':
                    boolean czySkręconoWLewo = samochod.getKierownica().kręćWLewo();
                    System.out.println("Czy skręcono w lewo: " + czySkręconoWLewo);
                    break;
                case ' ':
                    if (samochod.getKierownica().kręćWLewo()) {
                        samochod.getKierownica().zablokuj();
                    } else {
                        samochod.getKierownica().odblokuj();
                    }
                    break;
                case 'Q':
                    System.out.println("Koniec programu.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Niepoprawny wybór.");
                    break;
            }
        }
    }
}
