public class Abstraction {

    
}
abstract class Animal{
    
    public void eat(){
        System.out.println("Eating..........!");
    }
    abstract void walk();
}
class dog extends Animal{
    public void walk(){
        System.out.println("Dog is walking........!");
    }
}
interface  Chess{
void move();
}
class Queen implements Chess{
    public void move(){
    System.out.println("jata tatai");
   }
}