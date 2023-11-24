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
    }

    void odblokuj() {
        zablokowana = false;
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
public class Lab7Zad4 {

    public static void main(String[] args) {
        Samochod_2 samochod = new Samochod_2(4, 5);
        boolean czyUruchomiony = samochod.startuj();
        System.out.println("Czy samochód uruchomiony: " + czyUruchomiony);
        samochod.przyspiesz();
        System.out.println("Samochód przyspiesza.");

        boolean czySkręconoWLewo = samochod.getKierownica().kręćWLewo();
        System.out.println("Czy skręcono w lewo: " + czySkręconoWLewo);

        boolean czySkręconoWPrawo = samochod.getKierownica().kręćWPrawo();
        System.out.println("Czy skręcono w prawo: " + czySkręconoWPrawo);

        samochod.przyspiesz();
        System.out.println("Samochód przyspiesza ponownie.");

        samochod.hamuj(20);
        System.out.println("Samochód hamuje.");

        System.out.println("Stan kierownicy: " + samochod.getKierownica());

        samochod.getKierownica().zablokuj();
        System.out.println("Kierownica zablokowana.");

        samochod.getKierownica().odblokuj();
        System.out.println("Kierownica odblokowana.");
    }
}
