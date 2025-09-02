 import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in); 
            int n , num;
            
            System.out.print("Enter a number: ");
            n = sc.nextInt();
            num = n;
            int r=0;

            do {
                r = r * 10 + n % 10;
                n = n / 10;
            } while (n > 0);
        
        if (num == r)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}

