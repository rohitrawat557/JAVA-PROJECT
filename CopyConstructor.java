 public class CopyConstructor {
    public static void main(String[] args) {
        Student s1 = new Student("Rohit", 21);  // normal constructor
        Student s2 = new Student(s1);           // copy constructor

        s1.display();
        s2.display();
    }
}

class Student {
    String name;
    int age;

    // Normal constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Student(Student obj) {
        this.name = obj.name;
        this.age = obj.age;
    }

    void display() {
        System.out.println(name + " - " + age);
    }
}
