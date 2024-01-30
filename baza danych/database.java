import java.io.File;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Samochod {
    private String marka;
    private String model;
    private int rokProd;
    private int pojSilnika;
    private int mocSilnika;

    public Samochod(String marka, String model, int rokProd, int pojSilnika, int mocSilnika) {
        this.marka = marka;
        this.model = model;
        this.rokProd = rokProd;
        this.pojSilnika = pojSilnika;
        this.mocSilnika = mocSilnika;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getRokProd() {
        return rokProd;
    }

    public int getPojSilnika() {
        return pojSilnika;
    }

    public int getMocSilnika() {
        return mocSilnika;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRokProd(int rokProd) {
        this.rokProd = rokProd;
    }

    public void setPojSilnika(int pojSilnika) {
        this.pojSilnika = pojSilnika;
    }

    public void setMocSilnika(int mocSilnika) {
        this.mocSilnika = mocSilnika;
    }
}

class bazaSamochodow {
    private List<Samochod> samochody;
    public bazaSamochodow() {
        samochody = new ArrayList<>();
    }

    public void dodajSamochod(Samochod samochod) {
        samochody.add(samochod);
    }

    public void usunSamochod(Samochod samochod) {
        samochody.remove(samochod);
    }

    public void wyswietlWszystkieSamochody() {
        for (Samochod samochod : samochody) {
            wyswietlSamochod(samochod, samochody.indexOf(samochod));
        }
    }

    public void wyswietlSamochod(Samochod samochod, int numer) {
        System.out.println("Marka: " + samochod.getMarka());
        System.out.println("Model: " + samochod.getModel());
        System.out.println("Rok produkcji: " + samochod.getRokProd());
        System.out.println("Pojemnosc silnika: " + samochod.getPojSilnika());
        System.out.println("Moc silnika: " + samochod.getMocSilnika());
        System.out.println();
    }

    void loadFromFile(String fileName) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String marka = scanner.nextLine();
                String model = scanner.nextLine();
                int rokProd = scanner.nextInt();
                int pojSilnika = scanner.nextInt();
                int mocSilnika = scanner.nextInt();
                scanner.nextLine();
                Samochod samochod = new Samochod(marka, model, rokProd, pojSilnika, mocSilnika);
                dodajSamochod(samochod);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    void saveToFile(String fileName) {
        File file = new File(fileName);
        try {
            PrintWriter printWriter = new PrintWriter(file);
            for (Samochod samochod : samochody) {
                printWriter.println(samochod.getMarka());
                printWriter.println(samochod.getModel());
                printWriter.println(samochod.getRokProd());
                printWriter.println(samochod.getPojSilnika());
                printWriter.println(samochod.getMocSilnika());
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sortujBaze() {
    int choice = 0;
    Scanner scanner = new Scanner(System.in);
    while (choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5) {
        System.out.println("1. Sortuj po marce");
        System.out.println("2. Sortuj po modelu");
        System.out.println("3. Sortuj po roku produkcji");
        System.out.println("4. Sortuj po pojemnosci silnika");
        System.out.println("5. Sortuj po mocy silnika");
        System.out.println("6. Wyjscie");
        choice = scanner.nextInt();
    }
    switch (choice) {
        case 1:
            Collections.sort(samochody, (s1, s2) -> s1.getMarka().compareTo(s2.getMarka()));
            break;
        case 2:
            Collections.sort(samochody, (s1, s2) -> s1.getModel().compareTo(s2.getModel()));
            break;
        case 3:
            Collections.sort(samochody, (s1, s2) -> Integer.compare(s1.getRokProd(), s2.getRokProd()));
            break;
        case 4:
            Collections.sort(samochody, (s1, s2) -> Integer.compare(s1.getPojSilnika(), s2.getPojSilnika()));
            break;
        case 5:
            Collections.sort(samochody, (s1, s2) -> Integer.compare(s1.getMocSilnika(), s2.getMocSilnika()));
            break;
        case 6:
            break;
        }
    }

    public void menuPrzegladuBazy(String fileName) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while (choice!=1 && choice!=2 && choice!=3) {
            System.out.println("1. Wyswietl wszystkie samochody");
            System.out.println("2. Sortuj baze danych");
            System.out.println("3. Wyjście");
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 1:
                przegladBazy(fileName);
                break;
            case 2:
                sortujBaze();
                break;
            case 3:
                break;
        }
    }

    public void dodajDoListy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj marke samochodu: ");
        String marka = scanner.next();
        System.out.println("Podaj model samochodu: ");
        String model = scanner.next();
        System.out.println("Podaj rok produkcji samochodu: ");
        int rokProd = scanner.nextInt();
        System.out.println("Podaj pojemnosc silnika samochodu: ");
        int pojSilnika = scanner.nextInt();
        System.out.println("Podaj moc silnika samochodu: ");
        int mocSilnika = scanner.nextInt();
        Samochod samochod = new Samochod(marka, model, rokProd, pojSilnika, mocSilnika);
        dodajSamochod(samochod);
    }

    public void usunElementListy(int numer) {
        samochody.remove(numer);
    }

    public void modyfikujRekord(int numer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj marke samochodu: ");
        String marka = scanner.next();
        System.out.println("Podaj model samochodu: ");
        String model = scanner.next();
        System.out.println("Podaj rok produkcji samochodu: ");
        int rokProd = scanner.nextInt();
        System.out.println("Podaj pojemnosc silnika samochodu: ");
        int pojSilnika = scanner.nextInt();
        System.out.println("Podaj moc silnika samochodu: ");
        int mocSilnika = scanner.nextInt();
        Samochod samochod = new Samochod(marka, model, rokProd, pojSilnika, mocSilnika);
        samochody.set(numer, samochod);
    }

    public void przegladBazy(String fileName) {
        loadFromFile(fileName);
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        wyswietlWszystkieSamochody();

        while (choice!=1 && choice!=2 && choice!=3 && choice!=4) {
            System.out.println("1. Dodaj samochod");
            System.out.println("2. Usun samochod");
            System.out.println("3. Modifikuj rekord");
            System.out.println("4. Wyjscie");
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 1:
                dodajDoListy();
                break;
            case 2:
                System.out.println("Podaj numer samochodu do usuniecia: ");
                int numerUsun = scanner.nextInt();
                usunElementListy(numerUsun);
                break;
            case 3:
                System.out.println("Podaj numer samochodu do modyfikacji: ");
                int numerMod = scanner.nextInt();
                modyfikujRekord(numerMod);
                break;
            case 4:
                break;
        }
        saveToFile(fileName);
        
    }

    static boolean DBname(String filename) {
        boolean spr=false, spr1=false;
        if (filename.length()==10) {
            String strb = "baza";
            String strroz = ".dat";
            String str1 = filename.substring(0,4);
            String str2 = filename.substring(4,6);
            String str3 = filename.substring(6,10);
            int wynik21=0,wynik22=0;
            int wynik1 = str1.compareTo(strb);
            int wynik3 = str3.compareTo(strroz);
            char ch1 = str2.charAt(0);
            char ch2 = str2.charAt(1);
            if (Character.isDigit(ch1)) wynik21=1;
            if (Character.isDigit(ch2)) wynik22=1;
            int wynik = wynik1+wynik21+wynik22+wynik3;
            if (wynik==2) spr=true;
        }
        if (spr==false||spr1==false) System.out.println("Bledna nazwa pliku");
            else System.out.println("Nazwa pliku jest poprawna");
        return spr;
    }

    public String utworzBaze() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku: ");
        String fileName = scanner.next();
        if (DBname(fileName)) {
            File file = new File(fileName);
            if (file.exists()) {
                System.out.println("Plik juz istnieje");
                fileName = null;
            } else {
                try {
                    file.createNewFile();
                    System.out.println("Plik zostal utworzony");
                    file = new File(fileName);
                    menuPrzegladuBazy(fileName);
                    
                } catch (IOException e) {
                    e.printStackTrace();
                    fileName = null;
                }
            }
        }
        return fileName;
        
    }

    public String otworzBaze() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku: ");
        String fileName = scanner.next();
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("Baza danych zostala otwarta");

            menuPrzegladuBazy(fileName);
            return fileName;
        } else {
            System.out.println("Plik nie istnieje");
            return null;
        }
    }

    public void usunBaze(String openedFile) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("Podaj nazwe pliku do usuniecia: ");
        String fileName = scanner.next();
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("Czy na pewno chcesz usunac plik?");
            System.out.println("1. Tak");
            System.out.println("2. Nie");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    file.delete();
                    break;
                case 2:
                    break;
            }
        }
    }
}

public class database {
    public static void main(String[] args) {
        bazaSamochodow baza = new bazaSamochodow();
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        String openedFile = null;

        while (choice!=1 && choice!=2 && choice!=3 && choice!=4) {
            System.out.println("1. Utworz baze danych");
            System.out.println("2. Otworz baze danych");
            System.out.println("3. Usun baze danych");
            System.out.println("4. Wyjscie");
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 1:
                openedFile = baza.utworzBaze();
                break;
            case 2:
                openedFile = baza.otworzBaze();
                break;
            case 3:
                baza.usunBaze(openedFile);
                break;
            case 4:
                System.out.println("Zamykanie programu");
                break;
        }
    }
}
