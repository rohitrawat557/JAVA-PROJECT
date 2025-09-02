import java.util.*;

class Switch {
    public static void main(String arr[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number A: ");
            int a = sc.nextInt();
            System.out.println("Enter the number B: ");
            int b = sc.nextInt();

            int result;
            if (a > b) {
                result = 1;
            }

            else if (a < b) {
                result = 2;
            }

            else {
                result = 0;
            }

            switch (result) {
                case 1:
                    System.out.println(a  + " is greater number");
                    break;
                case 2:
                    System.out.println(b  + " is greater number");
                    break;

                case 3:
                    System.out.println("Both number are equal");

                default:

                    break;
            }
        }
    }
}
