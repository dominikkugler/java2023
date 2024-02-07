import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String make;
    private String model;
    private int year;
    private int engineSize;
    private int horsePower;

    public Car(String make, String model, int year, int engineSize, int horsePower) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engineSize = engineSize;
        this.horsePower = horsePower;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

}

class carDB {
    private List<Car> cars;
    public carDB() {
        cars = new ArrayList<Car>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public void displayCar(Car car, int index) {
        System.out.println("Samochod nr " + index);
        System.out.println("Marka: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Rok: " + car.getYear());
        System.out.println("Pojemnosc silnika: " + car.getEngineSize());
        System.out.println("Moc: " + car.getHorsePower());
        System.out.println();
    }

    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName,false))) {
            for (Car car : cars) {
                writer.println(car.getMake());
                writer.println(car.getModel());
                writer.println(car.getYear());
                writer.println(car.getEngineSize());
                writer.println(car.getHorsePower());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String make = line;
                String model = reader.readLine();
                int year = Integer.parseInt(reader.readLine());
                int engineSize = Integer.parseInt(reader.readLine());
                int horsePower = Integer.parseInt(reader.readLine());
                Car car = new Car(make, model, year, engineSize, horsePower);
                addCar(car);
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
    }
    
    boolean DBname(String filename) {
        boolean result = false;
        if (filename.matches("baza\\d{2}\\.dat")) {
            result = true;
        }
        return result;
    }
    public void addToList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj marke: ");
        String make = scanner.next();
        System.out.println("Podaj model: ");
        String model = scanner.next();
        System.out.println("Podaj rok: ");
        int year = scanner.nextInt();
        System.out.println("Podaj pojemnosc silnika: ");
        int engineSize = scanner.nextInt();
        System.out.println("Podaj moc: ");
        int horsePower = scanner.nextInt();
        Car car = new Car(make, model, year, engineSize, horsePower);
        addCar(car);
    }

    public void modifyCar(Car car) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5 && choice!=6) {
            System.out.println("1. Zmien marke");
            System.out.println("2. Zmien model");
            System.out.println("3. Zmien rok");
            System.out.println("4. Zmien pojemnosc silnika");
            System.out.println("5. Zmien moc");
            System.out.println("6. Zmien cala zawartosc");;
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 1: {
                System.out.println("Podaj nowa marke: ");
                String make = scanner.next();
                car.setMake(make);
            } break;
            case 2: {
                System.out.println("Podaj nowy model: ");
                String model = scanner.next();
                car.setModel(model);
            } break;
            case 3: {
                System.out.println("Podaj nowy rok: ");
                int year = scanner.nextInt();
                car.setYear(year);
            } break;
            case 4: {
                System.out.println("Podaj nowa pojemnosc silnika: ");
                int engineSize = scanner.nextInt();
                car.setEngineSize(engineSize);
            } break;
            case 5: {
                System.out.println("Podaj nowa moc: ");
                int horsePower = scanner.nextInt();
                car.setHorsePower(horsePower);
            } break;
            case 6: {
                System.out.println("Podaj nowa marke: ");
                String make = scanner.next();
                System.out.println("Podaj nowy model: ");
                String model = scanner.next();
                System.out.println("Podaj nowy rok: ");
                int year = scanner.nextInt();
                System.out.println("Podaj nowa pojemnosc silnika: ");
                int engineSize = scanner.nextInt();
                System.out.println("Podaj nowa moc: ");
                int horsePower = scanner.nextInt();
                car.setMake(make);
                car.setModel(model);
                car.setYear(year);
                car.setEngineSize(engineSize);
                car.setHorsePower(horsePower);
            } break;
        }
    }

    public void menu(String filename) {
        loadFromFile(filename);
        int choice = 0;
        int currentIndex = 0;
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            choice = 0;
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
                    quit = true;       
                    break;
                default:
                    System.out.println("Niepoprawny wybor");
                    break;
            }
            saveToFile(filename);
        }
    }
    

    public void menuOverview(String filename) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while (choice!=3) {
            choice = 0;
            while (choice!=1 && choice!=2 && choice!=3) {
                System.out.println("1. Wyswietl baze danych");
                System.out.println("2. Sortuj baze danych");
                System.out.println("3. Wyjdz");
                choice = scanner.nextInt();
            }

            switch (choice) {
                case 1: 
                    menu(filename);
                    break;
                case 2: 
                    sortDB(filename);
                    break;
                case 3:
                    break;
            }
        }
    }

    public void createFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku: ");
        System.out.println("Plik musi być w formacie bazaXX.dat");
        String filename = scanner.next();
        if (DBname(filename)) {
            File file = new File(filename);
            try {
                boolean result = file.createNewFile();
                if (result) {
                    System.out.println("Plik zostal utworzony");
                    menuOverview(filename);
                } else {
                    System.out.println("Plik juz istnieje");
                }
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void openFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku: ");
        System.out.println("Plik musi być w formacie bazaXX.dat");
        String filename = scanner.next();
        File file = new File(filename);

        if (file.exists()) {
            System.out.println("Baza została otwarta");
            menuOverview(filename);
        } else {
            System.out.println("Plik nie istnieje");
        }
    }

    public void deleteFile() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("Podaj nazwe pliku do usuniecia: ");
        System.out.println("Plik musi być w formacie bazaXX.dat");
        String filename = scanner.next();
        File file = new File(filename);

        if (file.exists()) {
            while (choice!=1 && choice!=2) {
                System.out.println("Czy na pewno chcesz usunac plik? (1 - Tak, 2 - Nie)");
                choice = scanner.nextInt();
            }
            if (choice == 1) {
                file.delete();
                System.out.println("Plik zostal usuniety");
            } else {
                System.out.println("Plik nie zostal usuniety");
            }
        }
    }

    public void sortDB(String filename) {
        loadFromFile(filename);
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while (choice!=1 && choice!=2) {
            System.out.println("1. Sortuj rosnąco");
            System.out.println("2. Sortuj malejąco");
            choice = scanner.nextInt();
        }
        int choice2 = 0;
        while (choice2!=1 && choice2!=2 && choice2!=3 && choice2!=4 && choice2!=5) {
            System.out.println("1. Sortuj po marce");
            System.out.println("2. Sortuj po modelu");
            System.out.println("3. Sortuj po roku");
            System.out.println("4. Sortuj po pojemnosci silnika");
            System.out.println("5. Sortuj po mocy");
            choice2 = scanner.nextInt();
        }

        switch (choice2) {
            case 1: 
                if (choice == 1) {
                    cars.sort((Car c1, Car c2) -> c1.getMake().compareTo(c2.getMake()));
                } else {
                    cars.sort((Car c1, Car c2) -> c2.getMake().compareTo(c1.getMake()));
                }
                break;
            case 2: 
                if (choice == 1) {
                    cars.sort((Car c1, Car c2) -> c1.getModel().compareTo(c2.getModel()));
                } else {
                    cars.sort((Car c1, Car c2) -> c2.getModel().compareTo(c1.getModel()));
                }
                break;
            case 3: 
                if (choice == 1) {
                    cars.sort((Car c1, Car c2) -> c1.getYear() - c2.getYear());
                } else {
                    cars.sort((Car c1, Car c2) -> c2.getYear() - c1.getYear());
                }
                break;
            case 4: 
                if (choice == 1) {
                    cars.sort((Car c1, Car c2) -> c1.getEngineSize() - c2.getEngineSize());
                } else {
                    cars.sort((Car c1, Car c2) -> c2.getEngineSize() - c1.getEngineSize());
                }
                break;
            case 5: 
                if (choice == 1) {
                    cars.sort((Car c1, Car c2) -> c1.getHorsePower() - c2.getHorsePower());
                } else {
                    cars.sort((Car c1, Car c2) -> c2.getHorsePower() - c1.getHorsePower());
                }
                break;
        }
        saveToFile(filename);
    }
}

public class database {
    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        carDB carDB = new carDB();
        boolean quit = false;

        while (!quit) {
            System.out.println("1. Utworz baze danych");
            System.out.println("2. Otworz baze danych");
            System.out.println("3. Usun baze danych");
            System.out.println("4. Wyjdz");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    carDB.createFile();
                    break;
                case 2: 
                    carDB.openFile();
                    break;
                case 3: 
                    carDB.deleteFile();
                    break;
                case 4: 
                    quit = true;
                    break;
                default:
                    System.out.println("Niepoprawny wybor");
                    break;
            }
            choice = 0;
        }
    }
}
