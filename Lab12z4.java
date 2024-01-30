import java.io.*;

public class Lab12z4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        PrintWriter pw = new PrintWriter(new FileWriter("tekst1.dat"), true);
        String s;
        while ((s = br.readLine()) != null)
            pw.println(s);
        br.close();
        pw.close();

        // Read and print the contents of tekst1.dat
        BufferedReader fileReader = new BufferedReader(new FileReader("tekst1.dat"));
        String line;
        while ((line = fileReader.readLine()) != null) {
            System.out.println(line);
        }
        fileReader.close();
    }
}
