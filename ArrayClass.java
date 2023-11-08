import java.util.*;
public class ArrayClass {
    
    public static int linearSearch(String menu[],String key){
        for(int i=0;i<menu.length;i++){
            if(menu[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void trappingRainWater(int height[],int width){
        int leftmax[] = new int[height.length];
        int rightmax[]= new int[height.length];
        leftmax[0]=height[0];
        for(int i=1;i<height.length;i++){
            leftmax[i]=Math.max(height[i],leftmax[i-1]);
        }
        rightmax[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rightmax[i]=Math.max(height[i],rightmax[i+1]);
        }
        int trappedWater=0;
        
        for(int i=0;i<height.length;i++){
            int waterLevel=Math.min(leftmax[i],rightmax[i]);
            trappedWater +=(waterLevel-height[i])*width;
        }
        System.out.println("total trapped water is :"+trappedWater);

    }
    public static int binarySearch(int number[],int key){
int start =0;
int end =number.length-1;

while(start<=end){
     int mid =(start+end)/2;
    if(key>number[mid]){
        start=mid+1;
       
    }
    else if(key<number[mid]){
        end=mid-1;
    }
    else{
        return mid;
    }
}
return -1;

    }
    public static void reverseArray(int number[]){

        int temp,first=0,last=number.length-1;
        while(first<last){
            temp= number[first];
            number[first]=number[last];
            number[last]=temp;
            first++;
            last--;
        }

    }

    public static int largest_number(int num[]){
 int largest = Integer.MIN_VALUE;
 for(int i=0;i<num.length;i++){
    if(largest<num[i]){
        largest=num[i];
    }
 }
 return largest;
    }
    public static void pair(int number[]){
        for(int i=0;i<number.length;i++){
            int num =number[i];
            for(int j= i+1;j<number.length;j++){
                System.out.print("("+num+","+number[j]+")\t");
            }
            System.out.println();
        }
    }
    public static void subArray(int number[]){
for(int i=0;i<number.length;i++){
    for(int j=i;j<number.length;j++){
        for(int k=i;k<=j;k++){
            System.out.print(number[k]+" ");
        }
        System.out.println();
    
    }
    System.out.println();
}
    }
    public static void maxSubArray(int number[]){
        int currentsum=0;
        int Max= Integer.MIN_VALUE;

        for(int i=0;i<number.length;i++){
            for(int j=i;j<number.length;j++){
                currentsum=0;
                for(int k=i;k<=j;k++){
                    currentsum +=number[k];
                }
                if(Max<currentsum){
                    Max=currentsum;
                }
            
            }
        }
        System.out.println("Maximum sum of subarray is: "+Max);
            }
            public static void maxSubArrayPrefix(int number[]){
                int currentsum=0;
                int Max= Integer.MIN_VALUE;
                int prefix[] = new int[number.length];
        prefix[0]=number[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i] = prefix[i-1]+number[i];
        }
                for(int i=0;i<number.length;i++){
                    for(int j=i;j<number.length;j++){
                        currentsum= i==0?prefix[j]:prefix[j] - prefix[i-1];
                        
                        if(Max<currentsum){
                            Max=currentsum;
                        }
                    
                    }
                }
                System.out.println("Maximum sum of subarray is: "+Max);
                    }
                    
                    public static int buyAndSellStock(int price[]){
                        int buyPrice = Integer.MAX_VALUE;
                        int maxProfit=0;
                        for(int i=0;i<price.length;i++){
                            if(buyPrice<price[i]){
                                int profit = price[i]-buyPrice;
                                maxProfit =Math.max(maxProfit,profit);
                            }
                            else{
                                buyPrice=price[i];
                            }
                        }
                        return maxProfit;
                    }
                    public static boolean repeatedValue(int number[]){
                    for(int i=0;i<number.length;i++){
                        for(int j = i+1;j<number.length;j++){
                            if(number[i]==number[j]){
                                return true;
                            }
                            
                        }
                    }
                    return false;
                    }
                    

    public static void main(String args[]){

 /*String menu[] ={"dosa","Parotha","chaat","samosa","coke","chai"};
 String key ="samosa";
 int index= linearSearch(menu,key);
 if(index==-1){
    System.out.println(key + " not found");
 }else{
    System.out.println(key +" found at index :"+index);
 }
 int number[]={1,2,6,8,76,56,43};
 System.out.println("largest number is :"+largest_number(number));
 
int number[]={1,3,5,23,56,64,70,75,88,90};
int key = 65;
 int index= binarySearch(number,key);
 if(index==-1){
    System.out.println(key + " not found");
 }else{
    System.out.println(key +" found at index :"+index);
    }
    int number[]={1,2,6,8,76,56,43};
    reverseArray(number);
    for(int i=0;i<number.length;i++){
        System.out.print(number[i]+"\t");
    }
    int number[]={1,2,3,4,5,6};
    maxSubArray(number);
    
    int height[]={4,2,0,6,3,2,5};
    trappingRainWater(height,1);
    
    int price[]={7,1,5,3,6,4};
     System.out.println("The maxium Profit is :"+buyAndSellStock(price));*/
     int number[]={1,2,3,4};
     System.out.println(repeatedValue(number));
}
}

