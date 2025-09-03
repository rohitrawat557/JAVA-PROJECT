import java.io.*;

public class renameFile {
 public static void main(String[] args) {
    File f =new File("C:\\Users\\rohit\\desktop\\handling.txt");
    File r = new File("C:\\Users\\rohit\\desktop\\Rohit.txt");

    if(f.exists()){
        System.out.println(f.renameTo(r));
    }
    else{
        System.out.println("File doesn't exists...!");
    }
 }   
}
