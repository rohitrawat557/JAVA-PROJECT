import java.io.*;

public class createFile {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\rohit\\desktop\\ok.txt");
      if(f.createNewFile()){
      System.out.println("File sucessfully created...!");
      }
      else{
        System.out.println("File already exists...!");
      }
    }
}
