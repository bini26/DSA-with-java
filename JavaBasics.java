import java.util.*;
import java.lang.Math;
public class JavaBasics {
  public static boolean isPalindrom(int n){
   int  temp=n  ,rem , palindrom=0;
    while(n>0){
     rem = n%10;
     palindrom = palindrom*10+rem;
     n /=10;
    }
    if(temp==palindrom){
      return true;
    }
    else{
      return false;
    }
    
  }
    public static void main(String args[]){
      
     System.out.println(isPalindrom(1002));
}
}
