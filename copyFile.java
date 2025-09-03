import java.io.*;

public class copyFile {
public static void main(String[] args) throws IOException {
    FileInputStream r = new FileInputStream("C:\\Users\\rohit\\desktop\\Rohit.txt");
    FileOutputStream w = new FileOutputStream("C:\\Users\\rohit\\desktop\\Rawat.txt");

    int i;
    while((i=r.read()) != -1){
    w.write((char)i);
    }
    System.out.println("Data copied successfully...!");
}
}
