import java.io.*;

public class Lab12z1 {
    public static void main(String[] args) {
        double[] numbers = {1.2, 3.4, 5.6, 7.8, 9.0};
        String filePath = "/workspaces/java2023/numbers.dat";

        // Write array to file
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            for (double number : numbers) {
                outputStream.writeDouble(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read and print file
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filePath))) {
            while (inputStream.available() > 0) {
                double number = inputStream.readDouble();
                System.out.println(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
