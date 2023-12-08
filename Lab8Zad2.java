class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getVolume() {
        return length * width * height;
    }

    public double getCubeSide(double volume) {
        return Math.cbrt(volume);
    }
}

public class Lab8Zad2 {
    public static void main(String[] args) {
        Box box = new Box(5, 4, 3);
        double boxVolume = box.getVolume();
        System.out.println("Objętość pudełka: " + boxVolume);

        double cubeVolume = 64;
        double cubeSide = box.getCubeSide(cubeVolume);
        System.out.println("Bok sześcianu o objętości " + cubeVolume + ": " + cubeSide);
    }
}
