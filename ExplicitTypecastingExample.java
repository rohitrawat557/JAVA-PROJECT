public class ExplicitTypecastingExample {
  
    public static void main(String[] args) {
        double myDouble = 9.78;
        int myInt = (int) myDouble; // Explicit casting from double to int

        long myLong = 1234567890123L;
        int anotherInt = (int) myLong; // Explicit casting from long to int (potential data loss)

        System.out.println("Double value: " + myDouble);
        System.out.println("Integer value (from double): " + myInt);
        System.out.println("Long value: " + myLong);
        System.out.println("Integer value (from long): " + anotherInt);
    }
}

 