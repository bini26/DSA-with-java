public class Recursion {
    public static void main(String args[]){
        int a[]={1,5,4,5,4,5,7};
        //removeDuplicate("appannacollege", 0,new StringBuilder(""), new boolean [26] );
       //System.out.println(friendsPairingProblem(3));
       //printBinString(4, 0, new String(""));
       int n=3;
       towerOfHanoi(n, "Source", "Helper", "Destination");

    }
    public static void towerOfHanoi(int n,String s,String h,String d){
        if(n==1){
            System.out.println("Transfer disk "+n+" from "+s+" to "+d);
            return;
        }
        towerOfHanoi(n-1, s,d, h);
        System.out.println("Transfer disk "+n+" from "+s+" to "+d);
        towerOfHanoi(n-1, h, s, d);

    }
    public static void printBinString(int n,int lastPlace  , String str){
        if(n==0){
            System.out.println(str);
            return;
        }
            printBinString(n-1,0, str+"0");
            if(lastPlace==0){
printBinString(n-1, 1, str+"1");
            }
        
    }
    public static int friendsPairingProblem(int n){
        if(n==1||n==2){
            return n;
        }
        return friendsPairingProblem(n-1)+ ((n-1)*friendsPairingProblem(n-2));
    }
    public static void removeDuplicate(String s,int index,StringBuilder str,boolean map[]  ){
                
        

        if( index == s.length()){
            System.out.println(str);
            return;
        }
         char currentChar = s.charAt(index);
        if(!map[currentChar-'a']){
str.append(currentChar);
map[currentChar-'a']=true;
removeDuplicate(s, index+1, str, map);
        }
        else{
        removeDuplicate(s, index+1, str, map); 
        } 
    }
    public static int tilingProblem(int n){
       


        if(n==0||n==1){
            return 1;
        }

return tilingProblem(n-1)+tilingProblem(n-2);
    }

    public static void printDecreasingNumber(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
            
        System.out.print(n +"\t");
        printDecreasingNumber(n-1);
        
    }
    public static void printIncreasingNumber(int n){
        if(n==1){
            System.out.print(n +" ");
            return;
        }
        printIncreasingNumber(n-1);
        System.out.print(n+" ");
    }
    public static int factorial(int n){
        if(n==0||n==1){
            return 1;
        }
return n * factorial(n-1);

    }
    public static int sumOfNaturalNumber(int n){
        if(n==1){
            return 1;
        }
        return n+sumOfNaturalNumber(n-1);
    }
    public static int fibonacci(int n){
        if(n==1||n==2){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static boolean checkSorted(int a[],int i){
if(i==a.length-1){
    return true;
}
        if(a[i]>a[i+1]){
            return false;
        }
       return checkSorted(a,i+1);

    }
    public static int firstOccurance(int a[],int i){
        int key =5;
        if(i==a.length){
return -1;
        }
        if(key==a[i]){
            return i;
        }
        return firstOccurance(a, i+1);

    }
    public static int lastOccurance(int a[],int i){
        int key = 5;
        
        if(i==a.length){
            return -1;
        }
        int isFound = lastOccurance(a, i+1);
        if(isFound==-1 && a[i]==key){
            return i;
        }
        
        return isFound;
    }
    public static int length(String str) { 
        if(str.length() ==0) 
        {return 0;
        }
        return length(str.substring(1)) +1;
}
    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        return x*power(x, n-1);
    }
    public static int powerOptimized(int x,int n){//O(logn)
        if(n==1){
            return x;
        }
        int halfp = powerOptimized(x, n/2);
        int halfpSqt = halfp*halfp;
        if(n%2==1){
            return x* halfpSqt;
        }
        return halfpSqt;
    }
    
}
