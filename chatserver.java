 import java.net.*;
import java.io.*;

public class chatserver {
    public static void main(String[] args) throws Exception {
        ServerSocket ss=new ServerSocket(2000);
        Socket sk = ss.accept();
        BufferedReader cin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
        // for reding from server cmd prompt
        PrintStream cout=new PrintStream(sk.getOutputStream()); // for printing on server cmd
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        // for reading from same cmd prompt
        String s;
        while(true){
            
            s=cin.readLine();
            // s=s.concat("(client1)");
           
            if(s.equalsIgnoreCase("END")){
                cout.println("BYE");
                break;
            }
             System.out.print("Client: "+s+"\n");
             System.out.print("Server: ");
             s=stdin.readLine();
        
            cout.println(s);
            
        }
        sk.close();
        cin.close();
        cout.close();
        stdin.close();
     

    }
}
