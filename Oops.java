public class Oops {
    

    public static void main(String args[]){
Constructor c1 = new Constructor("radha");
c1.displayName();

    }
}
 class GetterSetter{

     private String color;
     
     String getcolor(){
        return color;
     }
     void setColor(String color){
this.color = color;
     }


}
class Calculator{
    //example for method overloading
    public int sum(int a,int b){
        return a+b;
    }
    public int sum(int a,int b,int c){
        return a+b+c;
    }
}
class Constructor{
    public String name;
    public Constructor(String name){
this.name=name;
System.out.println("Constructor is called");
    }
    public void displayName(){
        System.out.println(name);
    }
}
