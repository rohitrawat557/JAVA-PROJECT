 
import java.util.*;

public class ArrayPassing {
    public static void sum(int arr[]){
        int sum1=0,sum2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                sum1+=arr[i];
            }
            else{
                sum2+=arr[i];
            }
        }
        System.out.println("Sum of even numbers : "+sum1);
        System.out.println("Sum of odd numbers : "+sum2);
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the elements of array : ");
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
       sum(arr);
    }
}
