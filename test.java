
public class test {
    public static void main(String[] args) {
        int x = 23;
        int maska1 = 2;
        int maska2 = ~maska1;
        int maska3 = maska2 << 1;
        int maska4 = ~maska3;
        int maska5 = maska4 << 3;
        x = x | maska5;
        int maska6 = ~maska5;
        x = x | maska6;
        System.out.println(Integer.toBinaryString(x));
    }
}
