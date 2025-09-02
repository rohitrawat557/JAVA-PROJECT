  import java.util.*;
public class Array2 {
    public static void main(String args[]){
        int n;
        Scanner sc =  new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        n = sc.nextInt();
        int [] arr = new int[n];
       System.out.print("Enter the elements : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
         System.out.print("Even numbers : ");
     for(int i=0;i<n;i++){
        if(arr[i]%2==0){
             System.out.print(arr[i]+" ");
        }
        
     }
     System.out.println();

     System.out.print("Odd numbers : ");
        for(int i=0;i<n;i++){
          if(arr[i]%2!=0){ 
          System.out.print(arr[i]+ " ");
        }
       
        }
    }
}


