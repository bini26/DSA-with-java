public class DivideConquer {
    public static void printArray(int arr[]){
for(int i=0;i<arr.length;i++){
    System.out.print(arr[i]+" ");
}
System.out.println();
    }
public static void main(String args[]){
int a[]={4,5,6,7,0,1,2};
//mergeSort(a, 0, a.length-1);
//quickSort(a, 0, a.length-1);
int target=7;
int tarindex = search(a,target,0,a.length-1);
System.out.print(tarindex);
//printArray(a);
}
public static int search(int arr[],int target,int start,int end){
    if(start>end){
        return -1;
    }
    int mid = start +(end-start)/2;
    //case mid found
if(arr[mid]==target){
    return mid;
}
//mid on line1
if(arr[start]<=arr[mid]){
    if(arr[start]<=target&&target<=arr[mid]){
return search(arr,target,start,mid);
    }else{
        return search(arr,target,mid+1,end);
    }
}
//mid on line2
else{
    if(arr[mid]<=target&&target<=arr[end]){
        return search(arr,target,mid+1,end);
    }
    else{
        return search(arr,target,start,mid);
    }
}
}
public static void mergeSort(int arr[],int start,int end){
    
    if(start>=end){
        return;
    }
int mid = start+(end-start)/2;
mergeSort(arr, start, mid);
mergeSort(arr, mid+1, end);
merge(arr, start, mid, end);

}
public static void merge(int arr[],int start,int mid,int end){

    int temp[]=new int[end-start+1];
    int i=start;
    int j=mid+1;
    int k=0;
    while(i<=mid&&j<=end){
        if(arr[i]<arr[j]){
            temp[k]=arr[i];
            i++;
        }else{
            temp[k]=arr[j];
            j++;
            
        }
        k++;
    }
    while(i<=mid){
        temp[k++]=arr[i++];
    }
    while(j<=end){
        temp[k++]=arr[j++];
    }
    for(k=0,i=start;k<temp.length;k++,i++){
        arr[i]=temp[k];
    }
    
}
public static void quickSort(int arr[],int start,int end){
    if(start>=end){
        return;
    }
    int pindex = partition(arr,start,end);
    quickSort(arr, start, pindex-1);
    quickSort(arr, pindex, end);

}
public static int partition(int arr[],int start,int end){
    int pivot=arr[end];
    int i=start-1;
 
    for(int j=start;j<end;j++){
        if(arr[j]<=pivot){
i++;
int temp  =arr[j];
arr[j]=arr[i];
arr[i]=temp;
        }
    }
    i++;
    int temp= pivot;
    arr[end]=arr[i];
    arr[i]=temp;
    return i;

}
    }



