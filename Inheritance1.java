
// Parent class
class Person{
    int id;
    String name;

    void setPerson(int id,String name){
        this.id = id;
        this.name = name;
    }
    void displayPerson(){
        System.out.println(id);
        System.out.println(name);
    }
}
// Child class

class Employee extends Person{
int salary;
String address;

void setEmployee(int id,String name,int salary,String address){
    setPerson(id, name);
    this.salary = salary;
    this.address = address;
}
    void displayEmployee(){
    displayPerson();
    System.out.println(salary);
    System.out.println(address);
 }
}

public class Inheritance1 {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setEmployee(101,"Rohit",60000,"Delhi");
        e1.displayEmployee();
    }
}
