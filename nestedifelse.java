// 1. Check if a number is positive, negative or zero, and also even or odd (if not zero)

import java.util.* ;
 class nestedifelse {
public static void main(String arr[]) {
      double num;
      try (Scanner sc = new Scanner (System.in)) {
        System.out.println("Enter a number");
        num = sc.nextDouble();
      }
      if (num>0) {
        System.out.println("num is positive");
        if (num % 2 == 0) {
            System.out.println("num is even");
        }
        else{
            System.out.println("num is odd");
        }
      }
      else if (num < 0) {
        System.out.println("num is negative");
        if (num % 2 == 0) {
            System.out.println("num is even");
        }
        else{
            System.out.println("num is odd");
        }
      }
      else{
        System.out.println("num is zero");
      }
      
   }

} 