abstract class Animal{
    abstract void walk();
    public void eat(){
        System.out.println("Animal eats");
    } 
}
class Horse extends Animal{
    public void walk(){
        System.out.println("Walks on 4 legs");
    }
}
class Chicken extends Animal{
    public void walk(){
        System.out.println("Walks on 2 legs ");
    }
}

public class Abstaraction1 {
    public static void main(String[] args) {
        Horse horse = new Horse();
        horse.walk();
        horse.eat();
    }
}
