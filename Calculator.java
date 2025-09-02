 import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double num1, num2, ans;
        char op;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number:");
        num1 = sc.nextDouble();

        System.out.println("Enter the second number:");
        num2 = sc.nextDouble();

        System.out.println("Enter the operator (+, -, *, /):");
        op = sc.next().charAt(0);

        switch (op) {
            case '+':
                ans = num1 + num2;
                System.out.println("Result: " + ans);
                break;
            case '-':
                ans = num1 - num2;
                System.out.println("Result: " + ans);
                break;
            case '*':
                ans = num1 * num2;
                System.out.println("Result: " + ans);
                break;
            case '/':
                if (num2 != 0) {
                    ans = num1 / num2;
                    System.out.println("Result: " + ans);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid operator.");
        }
        sc.close();
    }
}