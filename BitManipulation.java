public class BitManipulation {
    public static void oddOrEven(int n){
        int bitMask =1;
        if((n & bitMask)==0){
            System.out.println("The given number "+n+" is even");
        }else{
            System.out.println("The given number "+n+" is odd");
        }
    }
    public static int getIthBit(int n,int i){
        int bitMask=(1<<i);
        if((n&bitMask)==0){
            return 0;
        }
        else{
            return 1;
        }

    }
    public static void setIthBit(int n,int i){
        int bitMask = (1<<i);
        n = (n|bitMask);
        System.out.println("After setting ith position as 1 the number is :"+n);
    }
    public static int clearIthBit(int n,int i){
        int bitMask =~(1<<i);
        return (n & bitMask);
    }
    public static int clearLastIBit(int n,int i){
        int bitMask = (~0)<<i;
        return (n&bitMask);
    }
    public static int clearRangeOfBits(int n,int i,int j){
        int a = (~0)<<(j+1);
        int b= (1<<i)-1;
        int bitMask=a|b;
        return n&bitMask; 
    }
    public static void powerof2(int n){
        if((n&n-1)==0){
            System.out.println("Power of 2");
        }else{
            System.out.println("Not power of 2");
        }
    }
    public static void countSetBit(int n){
        int count =0;
        while(n>0){
            int bitMask =1;
            
            if((n&bitMask)==1){
count++;
            }
            n = n>>1;
        }
        System.out.println("Number of set bit is : "+count);
    }
    public static void fastExponentiation(int a,int n){
        int ans =1;
        while(n>0){
            if((n&1)!=0){
ans = ans *a;}
a = a*a;
n= n>>1;

        }
        System.out.println(ans);
    }
    public static void swap(int x,int y){
        x=x^y;
        y=x^y;
        x=x^y;
        System.out.println("After swap: "+x+","+y);
    }
    public static void UpperToLower(char ch){
        System.out.println((char)(ch | ' '));
    }
    public static void main(String args[]){
/*int n=13;
oddOrEven(n);
int n=15;
int i=2;
System.out.println(getIthBit(n, i));
setIthBit(10, 2);
System.out.println(clearIthBit(10,1));
powerof2(7);
countSetBit(15);*/
fastExponentiation(3, 5);
    }
}
