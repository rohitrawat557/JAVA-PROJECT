public class stringPalindrome {
    public static void main(String[] args) {
        String s = "RaR";
        int l=s.length();
        int flag=0;
        for(int i=0,j=l-1;i<l;i++;j++){
        {
              if(s.charAt(i) == s.charAt(j)){
        flag = 1;
       }
       else{
        flag = 0;
        break;
       }
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
