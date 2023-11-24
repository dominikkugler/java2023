public class Lab6Zad6 {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "hello";
        String str3 = "World";
        
        // equals
        System.out.println("str1 equals str2: " + str1.equals(str2)); // false
        System.out.println("str1 equals str3: " + str1.equals(str3)); // false
        
        // equalsIgnoreCase
        System.out.println("str1 equalsIgnoreCase str2: " + str1.equalsIgnoreCase(str2)); // true
        System.out.println("str1 equalsIgnoreCase str3: " + str1.equalsIgnoreCase(str3)); // false
        
        // compareTo
        System.out.println("str1 compareTo str2: " + str1.compareTo(str2)); // -32
        System.out.println("str1 compareTo str3: " + str1.compareTo(str3)); // -15
        
        // compareIgnoreCase
        System.out.println("str1 compareIgnoreCase str2: " + str1.compareToIgnoreCase(str2)); // 0
        System.out.println("str1 compareIgnoreCase str3: " + str1.compareToIgnoreCase(str3)); // -15

        String s1 = "Ala ma kota i psa";
        String s2 = "kota";
        int index1 = s1.indexOf(s2);
        int index2 = s1.indexOf(s2, 5);
        System.out.println("Index of " + s2 + " in " + s1 + " is " + index1);
        System.out.println("Index of " + s2 + " in " + s1 + " starting from position 5 is " + index2);

        String str = "Nazwa";
        String strLower = str.toLowerCase();
        String strUpper = strLower.toUpperCase();
        System.out.println("Original string: " + str);
        System.out.println("Lowercase string: " + strLower);
        System.out.println("Uppercase string: " + strUpper);

        String str5 = " Kowalski ";
        String trimmedStr = str5.trim();
        System.out.println("Original string: " + str5);
        System.out.println("Trimmed string: " + trimmedStr);
        
    }
}
