public class Lab3Z4 {
    public static void main(String[] args) {
        Pierwsza pierwsza = new Pierwsza();
        double wynik = pierwsza.Oblicz(5);
        System.out.println("Wynik: " + wynik);
    }
}

class Pierwsza {
    private long silnia(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * silnia(n - 1);
    }

    public double Oblicz(int n) {
        double suma = 0.0;
        for (int i = 1; i <= n; i++) {
            suma += 1.0 / silnia(i);
        }
        return suma;
    }
}
