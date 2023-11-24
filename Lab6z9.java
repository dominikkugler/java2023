public class Lab6z9 {
    public static void main(String[] args) {
        String s1 = "programowanie";
        StringBuilder sb1 = new StringBuilder(s1);
        System.out.println(sb1);
        sb1.append(" obiektowe I");
        System.out.println(sb1);
        sb1.insert(0,"programowanie ");
        sb1.setCharAt(0, 'P');
        String convertedSb1 = sb1.toString();
        System.out.println(convertedSb1);
    }
}
