import java.util.*;
public class ReverseNumber {
    public static void main(String[] args) {
        int n,r;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number : ");
             n =sc.nextInt();
        }
        do{
            r = n%10;
            System.out.println(r);
            n = n/10;
            
         }
         while(n>0);
          
    }
}
