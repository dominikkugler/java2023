public class Lab6Zad4i5 {
    public static void main(String[] args) {
        String val1 = "\u5B66\uD8F0\uDE30";
        int length = val1.length();
        int codePointCount = val1.codePointCount(0, val1.length());

        System.out.println("Długość łańcucha: " + length);
        System.out.println("Liczba jednostek kodowych: " + codePointCount);

        String pozdrowienie="Hello";
        char first = pozdrowienie.charAt(0);
        int cp = pozdrowienie.codePointAt(0);
        System.out.println("Pierwszy znak: " + first);
        System.out.println("Kod punktu kodowego pierwszego znaku: " + cp);

        int cp1=0, cp2=0;
        cp1=val1.codePointAt(0);
        cp2=val1.codePointAt(1);
        System.out.println("Kod punktu kodowego pierwszego znaku: " + cp1);
        System.out.println("Kod punktu kodowego drugiego znaku: " + cp2);

        boolean if1 = Character.isSupplementaryCodePoint(cp1);
        boolean if2 = Character.isSupplementaryCodePoint(cp2);
        System.out.println("Czy kod punktu kodowego pierwszego znaku jest kodem punktu kodowego dodatkowego: " + if1);
        System.out.println("Czy kod punktu kodowego drugiego znaku jest kodem punktu kodowego dodatkowego: " + if2);
    }
}

