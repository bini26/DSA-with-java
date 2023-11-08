public class Inheritance {
    public static void main(String args[]) {
        Fish f1 = new Fish();
        f1.eat();
    }

}

// Base Class
class Animal {
    Animal() {
        System.out.println("Constructor of animal");
    }

    public String color;

    public void eat() {
        System.out.println("Eating......!");
    }

    public void breathe() {
        System.out.println("Breathing.........!");
    }
}

// Derive class
class Fish extends Animal {
    // Example of method overriding
    public void eat() {
        System.out.println("Fish ko daat kamjor hunxa");
    }

    public void swim() {
        System.out.println("Swimming......!");
    }
}