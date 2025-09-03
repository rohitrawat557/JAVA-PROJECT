import java.io.*;
public class fileReader {
    public static void main(String[] args) throws IOException {
        FileReader r = new FileReader("C:\\Users\\rohit\\desktop\\handling.txt");

        int i;
        while ((i=r.read()) != -1) {
            System.out.print((char)i);
        }
        
    }
}
