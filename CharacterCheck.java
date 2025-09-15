import java.util.*;

public class CharacterCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any character: ");
        char ch = sc.next().charAt(0); // Take first character input

        if (ch >= 'A' && ch <= 'Z') {
            System.out.println(ch + " is a Capital Letter.");
        } 
        else if (ch >= 'a' && ch <= 'z') {
            System.out.println(ch + " is a Small Letter.");
        } 
        else if (ch >= '0' && ch <= '9') {
            System.out.println(ch + " is a Digit.");
        } 
        else {
            System.out.println(ch + " is a Special Character.");
        }
    }
}
