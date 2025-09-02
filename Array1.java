import java.util.*;
public class Array1 {
    public static void main(String args[]){
        int n,count = 0;
        Scanner sc =  new Scanner(System.in);
        System.out.print("Enter the Size of Array : ");
        n = sc.nextInt();
        int [] arr = new int[n];
       System.out.print("Enter the elements : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
         System.out.println("Even numbers : ");
     for(int i=0;i<n;i++){
        if(arr[i]%2==0){
             System.out.println(arr[i]);
             count++;
        }
     
     }
      System.out.println("Total even numbers are : "+ count);

    }
}
