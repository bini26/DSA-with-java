import java.util.*;
public class Matrics {
    public static void Creating2DArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row and column of matrics: ");
        int row = sc.nextInt();
int column = sc.nextInt();
        int matrix[][]=new int[row][column];
        System.out.println("Please enter the array elements: ");
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println(" the matrix is: ");
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
               System.out.print( matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void spiralMatrix(int matrix[][]){
        int startRow = 0,endRow=matrix.length-1,startCol=0,endCol=matrix[0].length-1;
        while(startRow <= endRow && startCol<=endCol ){
for(int j=startCol;j<=endCol;j++){
System.out.print(matrix[startRow][j]+" ");

}
for(int i=startRow+1;i<=endRow;i++){
    System.out.print(matrix[i][endCol]+" ");
}
for(int j=endCol-1;j>=startCol;j--){
    if(startRow==endRow){
        break;
    }
    System.out.print(matrix[endRow][j]+" ");
}
for(int i=endRow-1;i>startRow;i--){
    if(startCol==endCol){
        break;
    }
    System.out.print(matrix[i][startCol]+" ");
}
startRow++;endRow--;startCol++;endCol--;
        }
    }
    public static void diagonalSum(int matrix[][]){
        int sum=0;
        /*for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==j){
                    sum +=matrix[i][j];
                }
                else if(i+j==(matrix.length-1)){
                    
                sum +=matrix[i][j];
                }
            }
            
        }*/
        for(int i=0;i<matrix.length;i++){
            sum +=matrix[i][i];
            if(i!=matrix.length-1-i){
sum +=matrix[i][matrix.length-1-i];
            }
        }
        System.out.println("The sum is : "+sum);
    }
    public static boolean stairCaseSearch(int matrix[][] , int key){
int row=0,col=matrix[0].length-1;
while(row<matrix.length && col>=0){
    if(matrix[row][col]==key){
        System.out.println("key found at ("+row+","+col+")");
        return true;
    }
    else if(key<matrix[row][col]){
        col--;
    }
    else{
        row++;
    }
}
System.out.println("key not found");
return false;
    }
    public static void main(String args[]){
        /*Creating2DArray();
        int matrix[][]={
            {1,2,3,4},{
                5,6,7,8
            },{9,10,11,12},{13,14,15,16}           
        };
        spiralMatrix(matrix);
        int matrix[][]={
            {0,1,2},
            {3,4,5},
            {6,7,8}
        };
        diagonalSum(matrix);*/
        int matrix[][]={
            {10,20,30,40},
            {15,25,35,45},
            {27,29,37,48},
            {32,33,39,30}
        };
        int key =37;
        stairCaseSearch(matrix, key);
    }

}
