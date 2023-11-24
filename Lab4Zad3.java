import java.util.Arrays;
import java.util.Scanner;

public class Lab4Zad3 {

    public static void main(String[] args) {
        int[] tab = {5, 1, 8, 3, 2, 7, 6, 4};
        int[] xSortAsc = new int[tab.length];
        
        int[] xSortDesc = sorttab(tab, xSortAsc);
        
        System.out.println("Tablica posortowana niemalejąco:");
        for(int value : xSortAsc) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("Tablica posortowana nierosnąco:");
        for(int value : xSortDesc) {
            System.out.print(value + " ");
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź wartość do wyszukania w tablicy posortowanej niemalejąco:");
        int searchValue = scanner.nextInt();
        
        int index = Arrays.binarySearch(xSortAsc, searchValue);
        if(index >= 0) {
            System.out.println("Element " + searchValue + " jest na pozycji: " + index);
        } else {
            System.out.println("Element nie został znaleziony w tablicy.");
        }
        scanner.close();
    }

    static int[] sorttab(int[] x, int[] xSortAsc) {
        System.arraycopy(x, 0, xSortAsc, 0, x.length);
        Arrays.sort(xSortAsc);

        int[] xSortDesc = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            xSortDesc[i] = xSortAsc[x.length - 1 - i];
        }

        return xSortDesc;
    }
}