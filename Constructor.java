 public class Constructor {
    int value;
    String name;

    // No-argument constructor
    public Constructor() {
        value = 0;
        name = "Rohit";
    }

    // Parameterized constructor
    public Constructor(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static void main(String[] args) {
        Constructor obj1 = new Constructor(); // Calls no-argument constructor
        System.out.println(obj1.value + " " + obj1.name);

        Constructor obj2 = new Constructor(10, "OK"); // Calls parameterized constructor
        System.out.println(obj2.value + " " + obj2.name);
    }
}