import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab12z5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueWriting = true;
        while (continueWriting) {
            System.out.print("Podaj nazwę pliku do zapisu: ");
            String fileName = scanner.nextLine();

            try {
                FileWriter fileWriter = new FileWriter(fileName);
                System.out.println("Plik został otwarty do zapisu.");

                // Tu umieść kod do zapisu danych do pliku

                fileWriter.close();
                System.out.println("Plik został zapisany.");

                System.out.print("Czy chcesz wypisać kolejny plik? (T/N): ");
                String answer = scanner.nextLine();
                continueWriting = answer.equalsIgnoreCase("T");
            } catch (IOException e) {
                System.out.println("Wystąpił błąd podczas zapisu pliku.");
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
