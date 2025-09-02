import java.io.*;

public class fileWriter {
    public static void main(String[] args) {
         try{
        FileWriter f = new FileWriter("C:\\Users\\rohit\\desktop\\handling.txt");
      try{
        f.write("i am the best");
      }
      finally{
        f.close();
      }
    System.out.println("Data is successfully wrote in File");
    }
    catch(IOException i){
System.out.println(i);
    }
    }
}
