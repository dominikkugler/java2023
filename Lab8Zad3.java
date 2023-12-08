import java.util.Scanner;

class Student1 {
    String nazwisko;
    String imie;
    double ocena1;
    double ocena2;
    double srednia;

    public void obliczSrednia() {
        srednia = (ocena1 + ocena2) / 2;
    }

    public void wypisz() {
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Imię: " + imie);
        System.out.println("Ocena 1: " + ocena1);
        System.out.println("Ocena 2: " + ocena2);
        System.out.println("Średnia: " + srednia);
    }
}

class Uczelnia1 {
    public static void main(String[] args) {
        Student1 student = new Student1();

        try (// Wczytaj dane studenta
                // Przykład wczytania danych z wejścia:
        Scanner scanner = new Scanner(System.in)) {
            System.out.print("Podaj nazwisko: ");
            student.nazwisko = scanner.nextLine();
            System.out.print("Podaj imię: ");
            student.imie = scanner.nextLine();
            System.out.print("Podaj ocenę 1: ");
            student.ocena1 = scanner.nextDouble();
            System.out.print("Podaj ocenę 2: ");
            student.ocena2 = scanner.nextDouble();
        }
        // Oblicz średnią
        student.obliczSrednia();

        // Wypisz dane studenta
        student.wypisz();
    }
}
