public class Lab6Zad5 {
    public static void main(String[] args) {
        String pozdrowienie="Hello";
        char first = pozdrowienie.charAt(0);
        int cp = pozdrowienie.codePointAt(0);
        System.out.println("Pierwszy znak: " + first);
        System.out.println("Kod punktu kodowego pierwszego znaku: " + cp);
    }
}
