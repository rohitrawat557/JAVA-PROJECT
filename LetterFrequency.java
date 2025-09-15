import java.util.*;
public class LetterFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();
        char letter = 'a'; 
        int count = 0;

    
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == letter) {
                count++;
            }
        }

        System.out.println("Frequency: " + count);
    }
}
