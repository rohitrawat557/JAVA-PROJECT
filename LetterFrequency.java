import java.util.*;
public class LetterFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();
         System.out.print("Enter a letter: ");
        char letter = sc.next().charAt(0);
        int count = 0;

    
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == letter) {
                count++;
            }
        }

        System.out.println("Frequency: " + count);
    }
}
