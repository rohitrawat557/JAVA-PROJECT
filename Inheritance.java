 class New1 {
    public void fun1() {
        System.out.println("This is a super class method");
    }
}

class New2 extends New1 {
    public void fun2() {
        System.out.println("This is subclass method");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        New2 t = new New2();
        t.fun1();
        t.fun2();
    }
}
