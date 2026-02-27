import java.net.*;
import java.io.*;

public class chatclient {
    public static void main(String[] args) throws Exception {
        Socket sk=new Socket("localhost",2000);
        BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
        // for reding from server cmd prompt
        PrintStream sout=new PrintStream(sk.getOutputStream()); // for printing on server cmd
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        // for reading from same cmd prompt
        String s;
        while(true){
            System.out.print("Client: ");
            s=stdin.readLine();
            // s=s.concat("(client1)");
            sout.println(s);
            s=sin.readLine();
            System.out.println("Server: "+s+"\n");
            if(s.equalsIgnoreCase("BYE"));
            break;
        }
        sk.close();
        sin.close();
        sout.close();
        stdin.close();
     

    }
}
