import java.util.Scanner;

public class gowno {
    public static void main(String[] args) {
        int choice = 0;
        int currentIndex = 0;
        Scanner scanner = new Scanner(System.in);
        while (choice!=6) {
            while (choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5 && choice!=6) {
                if (cars.size() > 0) {
                    displayCar(cars.get(currentIndex), currentIndex);
                } else {
                    System.out.println("Brak samochodow w bazie");
                }
                System.out.println("1. Wyswietl kolejny samochod");
                System.out.println("2. Wyswietl poprzedni samochod");
                System.out.println("3. Usun samochod");
                System.out.println("4. Dodaj samochod (na koniec listy)");
                System.out.println("5. Modyfikuj samochod");
                System.out.println("6. Wyjdz");
                choice = scanner.nextInt();
            }

            switch (choice) {
                case 1:
                    if (currentIndex < cars.size() - 1) {
                        currentIndex++;
                    } else {
                        System.out.println("Brak kolejnego samochodu");
                    }
                    break;
                case 2:
                    if (currentIndex > 0) {
                        currentIndex--;
                    } else {
                        System.out.println("Brak poprzedniego samochodu");
                    }
                    break;
                case 3:
                    removeCar(cars.get(currentIndex));
                    if (currentIndex > 0) {
                        currentIndex--;
                    }
                    break;
                case 4:
                    addToList();
                    break;
                case 5:
                    modifyCar(cars.get(currentIndex));
                    break;
                case 6:    
                    break;
            }
            saveToFile(filename);
            choice = 0;
        }
    }
}
