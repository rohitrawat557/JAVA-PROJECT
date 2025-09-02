 import java.util.*;

public class ArmstrongCheck {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int num = sc.nextInt();

            int temp = num;
            int sum = 0;

            do {
                int digit = temp % 10;
                sum += digit * digit * digit;
                temp = temp / 10;
            } while (temp > 0);

            if (sum == num)
                System.out.println(num + " is an Armstrong number.");
            else
                System.out.println(num + " is not an Armstrong number.");
        }
    }
}
