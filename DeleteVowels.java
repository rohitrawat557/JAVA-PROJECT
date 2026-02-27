import java.util.*;
     class DeleteVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string value: ");
        String str = sc.next();
        
        
        String result = str.replaceAll("[aeiouAEIOU]","");
        
    
        System.out.println(result);
    }
}


