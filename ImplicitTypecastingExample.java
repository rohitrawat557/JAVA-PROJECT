public class ImplicitTypecastingExample {
   
    public static void main(String[] args) {
        int myInt = 100;
        long myLong = myInt; // Implicit casting from int to long
        double myDouble = myLong; // Implicit casting from long to double

        System.out.println("Integer value: " + myInt);
        System.out.println("Long value: " + myLong);
        System.out.println("Double value: " + myDouble);
    }
}

