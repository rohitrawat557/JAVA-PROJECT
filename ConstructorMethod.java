 public class ConstructorMethod {
    String model;
    int year;

    // Constructor
    ConstructorMethod(String model, int year) {
        this.model = model; // 'this' refers to the current object's field
        this.year = year;
    }

    // Method
    void displayInfo() {
        System.out.println(this.model + " - " + this.year);
    }


 
    public static void main(String[] args) {
        ConstructorMethod c = new ConstructorMethod("Tesla", 2025); // Constructor is called automatically
        c.displayInfo(); // Method called explicitly
    }

 }