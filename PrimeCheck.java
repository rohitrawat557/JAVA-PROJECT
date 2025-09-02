public class PrimeCheck {
     int number;

    // Constructor to initialize the number
    public PrimeCheck(int num) {
        this.number = num;
    }

    // Method to check if the number is prime
    public boolean isPrime() {
        if (number <= 1) {
            return false; // 0 and 1 are not prime
        }
        // Check for divisibility from 2 up to the square root of the number
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false; // Found a divisor, so it's not prime
            }
        }
        return true; // No divisors found, so it's prime
    }

    public static void main(String[] args) {
        System.out.println("Prime numbers between 2 and 25:");
        for (int i = 2; i <= 25; i++) {
            PrimeCheck checker = new PrimeCheck(i); // Create an object for each number
            if (checker.isPrime()) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // New line for formatting
    }
}