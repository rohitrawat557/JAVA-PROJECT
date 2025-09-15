public class stringPalindrome {
    public static void main(String[] args) {
        String s = "Radar";
        int l=s.length();
        int i,j,flag=0;
        for(i=0;j=l-1::i<j;i++,j--){
       if(s.charAt(i) == s.charAt(j)){
        flag = 1;
       }
       else{
        flag = 0;
        break;
       }
        }
        if(flag != 0){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not palindrome");
        }
    }
}
