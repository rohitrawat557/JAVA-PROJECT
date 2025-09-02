import java.util.*;
public class Fibonacci {
    public static void main(String args[]){
        int n;
        int a = 0 , b = 1;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the value of n: ");
             n =sc.nextInt();
        }
        System.out.println("Fibonacci series: ");
        for(int i=1;i<=n;i++){
            System.out.println(a+" ");
        int c = a+b;
            a = b;
            b = c;
        }
    }
}
