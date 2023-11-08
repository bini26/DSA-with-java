public class BasicsSorting {
    public static void bubbleSort(int number[]){
        int temp,i,j;
        System.out.print("Array before sorting: ");
        for(i =0;i<number.length;i++){
            System.out.print(number[i]+" ");
        }
        for( i=0;i<number.length-1;i++){
            for(j=0;j<number.length-1-i;j++){
                temp=number[j];
                if(number[j]>number[j+1]){
                    
                    number[j]=number[j+1];
                    number[j+1]=temp;
                }
            }
        }
       
        
    }
    public static void desbubbleSort(int number[]){
        int temp,i,j;
        System.out.print("Array before sorting: ");
        for(i =0;i<number.length;i++){
            System.out.print(number[i]+" ");
        }
        for( i=0;i<number.length-1;i++){
            for(j=0;j<number.length-1-i;j++){
                temp=number[j];
                if(number[j]<number[j+1]){
                    
                    number[j]=number[j+1];
                    number[j+1]=temp;
                }
            }
        }
       
        
    }
    public static void Display(int arr[]){
        for( int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void selectionSort(int arr[]){
       
        for(int i=0;i<arr.length-1;i++){
            int Smallest= i ;
            for(int j=1+i;j<arr.length;j++){
                if(arr[Smallest]>arr[j]){
                    Smallest = j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[Smallest];
            arr[Smallest]=temp;
        }

    }
    public static void desselectionSort(int arr[]){
       
        for(int i=0;i<arr.length-1;i++){
            int largest= i ;
            for(int j=1+i;j<arr.length;j++){
                if(arr[largest]<arr[j]){
                    largest= j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
        }

    }
    public static void insertionSort(int arr[]){
    for(int i=1;i<arr.length;i++){
        int current = arr[i];
        int previous = i-1;
        while(previous>=0 && arr[previous]>current ){
arr[previous+1]=arr[previous];
previous--;
        }
        arr[previous+1]=current;
    }
    }
    public static void countSort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest = Math.max(largest,arr[i]);
        }
        int count[]=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }
public static void main(String args[]){

    int number[]={5,4,1,3,2};
   // bubbleSort(number);
   //selectionSort(number);
   //insertionSort(number);
   //countSort(number);
   //desbubbleSort(number);
   desselectionSort(number);
   Display(number);
    
}

}
