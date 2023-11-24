import java.util.Date;

public class Lab6Zad1 {
    public static void main(String[] args) {
        String s1 = "ANS";
        System.out.println("a) " + s1);

        String s2 = new String("ANS");
        System.out.println("b) " + s2);

        String s3 = new String(s2);
        System.out.println("c) " + s3);

        char[] tabZnakowa = {'a', 'b', 'c'};
        String s4 = new String(tabZnakowa);
        System.out.println("d) " + s4);
        
        Date currentDate = new Date();
        System.out.println("Dzisiaj jest " + currentDate);

        String liczbaStr="123";
        int liczbaInt = Integer.parseInt(liczbaStr);
        System.out.println("e) " + liczbaInt);
        int liczbaInt2 = Integer.valueOf(liczbaStr);
        System.out.println("f) " + liczbaInt2);
    }
}
