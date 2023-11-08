public class BackTracking{

    public static void changeArray(int arr[],int i,int val){
        if(i==arr.length){
            
            printArr(arr);
            return ;
        }
        arr[i]=val;
        changeArray(arr,i+1,val+1);
        arr[i]=arr[i]-2;
    }

    public static void findSubsets(String str,String ans,int i){
//base Case
if(i==str.length()){
    if(ans.length()==0){
        System.out.println("null");
        }
    else{
    System.out.println(ans);
    }
    return;
}
//recursion
//Yes
findSubsets(str,ans+str.charAt(i), i+1);
//No
findSubsets(str,ans,i+1);
    }
    public static void findPermutation(String str,String ans){

        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i=0;i<str.length();i++){
char curr = str.charAt(i);
//"abcde " if we take c as a current then="ab"+"de"
String str1=str.substring(0, i) +str.substring(i+1);
findPermutation(str1, ans+curr);
        }

    }
public static void printArr(int arr[]){
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+"\t");
    }
    System.out.println();
}
    public static void main(String args[]){
        /*int arr[]= new int[5];
        changeArray(arr,0,1);
        printArr(arr);*/
        String str="abc";
        //findSubsets(str, " ", 0);
        findPermutation(str, "");


    }
}