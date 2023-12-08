class Point {
    int x;
    int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void wyzeruj() {
        this.x = 0;
        this.y = 0;
    }

    public void przesun(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void wypisz() {
        System.out.println("Współrzędne: (" + this.x + ", " + this.y + ")");
    }
}

public class Lab8Zad1 {
    public static void main(String[] args) {
        Point punkt1 = new Point();
        Point punkt2 = new Point(10, 20);

        punkt2.x = 5;
        punkt2.y = 15;

        punkt1.wypisz();
        punkt2.wypisz();

        punkt1.wyzeruj();
        punkt1.wypisz();
    }
}
