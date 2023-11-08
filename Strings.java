import java.util.*;
public class Strings {
    public static void largeString(String str1,String str2){
        int cmp = str1.compareTo(str2);
        if(cmp==0){
            System.out.println("Both the String are equals");
        }
        else if(cmp>0){
            System.out.println(str1+" is greater than "+str2);

        }
        else{
            System.out.println(str2+" is greater than "+str1);
        }
    }
    public static void getShortestPath(String path){
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char dir =path.charAt(i);
                        if(dir =='N' ){
                            y++;
                            }
                            else if(dir =='S' ){
                                y--;
                                }
                                else if(dir =='W' ){
                                    x--;
                                    }
                                    else if(dir =='E' ){
                                        x++;
                                        }
        }
        int x2 = (x*x);
        int y2= (y*y);
        double distance =Math.sqrt(x2+y2);
        System.out.println("The Shortest distance is : "+distance);
    }
    public static boolean palindrom(String str){
        boolean isPalindrom = true;
for(int i=0;i<str.length()/2;i++){

    if(str.charAt(i)!=str.charAt(str.length()-1-i)){
         isPalindrom = false;
    }
}
return isPalindrom;
    }

    public static String compress(String str){
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)== str.charAt(i+1)){
count++;
i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count.toString());
            }

        }
        return sb.toString();
    }
public static int countVowel(String str){
    int count =0;
    for(int i=0;i<str.length();i++){
        if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
            count++;
        }
    }
    return count;
}
    public static void main(String args[]){
     /*Scanner sc = new Scanner(System.in);
     String name = sc.nextLine();
     System.out.println("Name : "+name);
     String str = "maedm";
       System.out.println( palindrom(str));
       String path ="WNEENESENNN";
       getShortestPath(path);
       String str1="banana";
       String str2 ="baname";
       largeString(str1, str2);
       String str ="aaaabbbbcccdde";
       System.out.println(compress(str));*/
       String vowel="aacerthyiijnutoknhfj";
       System.out.println(countVowel(vowel));
    }
}
