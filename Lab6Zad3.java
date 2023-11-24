
import java.util.Scanner;

public class Lab6Zad3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int unicodeCodePoint = 0;
        do {
            System.out.println("Podaj kod Unikodu (w zakresie 65536-111411):");
            String input = sc.next();
            try {
                unicodeCodePoint = Integer.parseInt(input, 16);
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawny format liczby heksadecymalnej.");
                continue;
            }
            if (unicodeCodePoint < 65536 || unicodeCodePoint > 111411) {
                System.out.println("Liczba spoza zakresu.");
            }
        } while (unicodeCodePoint < 65536 || unicodeCodePoint > 111411);
        sc.close();

        char highSurrogate = Character.highSurrogate(unicodeCodePoint);
        char lowSurrogate = Character.lowSurrogate(unicodeCodePoint);
        System.out.println("Górny surogat: " + (int) highSurrogate);
        System.out.println("Dolny surogat: " + (int) lowSurrogate);

        char high = highSurrogate;
        char low = lowSurrogate;
        int highValue = high - '\uD800';
        int lowValue = low - '\uDC00';
        int codePoint = (highValue << 10) + lowValue + 0x10000;
        System.out.println("Kod Unikodu dla surogatów " + (int) high + " i " + (int) low + ": " + codePoint);
    }
}
