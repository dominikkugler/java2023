class Student2 {
    private String nazwisko;
    private String imie;
    private double ocena1;
    private double ocena2;

    public Student2(String nazwisko, String imie) {
        this.nazwisko = nazwisko;
        this.imie = imie;
    }

    public boolean wstawOcene(double ocena) {
        if (ocena >= 2 && ocena <= 5) {
            if (ocena1 == 0) {
                ocena1 = ocena;
            } else if (ocena2 == 0) {
                ocena2 = ocena;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean wstawOcene(double ocena1, double ocena2) {
        if (ocena1 >= 2 && ocena1 <= 5 && ocena2 >= 2 && ocena2 <= 5) {
            this.ocena1 = ocena1;
            this.ocena2 = ocena2;
            return true;
        } else {
            return false;
        }
    }

    public double srednia() {
        return (ocena1 + ocena2) / 2;
    }
}

public class Lab8Zad4 {
    public static void main(String[] args) {
        Student2 student = new Student2("Kowalski", "Jan");
        boolean result1 = student.wstawOcene(4.5);
        boolean result2 = student.wstawOcene(3.8);
        boolean result3 = student.wstawOcene(4.0, 3.5);
        double srednia = student.srednia();
        System.out.println("Wyniki:");
        System.out.println("Czy udało się wstawić ocenę 1? " + result1);
        System.out.println("Czy udało się wstawić ocenę 2? " + result2);
        System.out.println("Czy udało się wstawić oceny? " + result3);
        System.out.println("Średnia ocen: " + srednia);
    }
}
