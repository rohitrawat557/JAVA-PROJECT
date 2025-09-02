 import java.util.Scanner;

public class FirstLastDigitSum {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int num = sc.nextInt();
            
            int lastDigit = num % 10;  
            int firstDigit = 0;

            do {
                firstDigit = num % 10;
                num = num / 10;
            } while (num > 0);

            int sum = firstDigit + lastDigit;

             
            System.out.println("Sum = " + sum);
        }
    }
}
