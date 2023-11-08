public class BackTrackingNQueen{
public static boolean isSafe(char board[][],int row,int col){
    //ver up
    for(int i=row;i>=0;i--){
        if(board[i][col]=='Q'){
            return false;
        }
        //daigonal leftup
        for(int k= row-1, j= col-1;k>=0&&j>=0;k--,j--){
if(board[k][j]=='Q'){
    return false;
}
        }
        //daigonal rightup
        for(int l=row-1,j=col+1;l>=0&&j<=board.length;l--,j++){
            if(board[l][j]=='Q'){
                return false;
            }
}
   
    }
    return true;

}
public static void nQueens(char board[][],int row){
    //base case
    if(row==board.length){
        printBoard(board);
        return;
    }
    //column loop
    for(int j=0;j<board.length;j++){
        if(isSafe(board, row, j)){
            board[row][j]='Q';
            nQueens(board, row+1);
            board[row][j]='x';
        }
    }
}
public static void printBoard(char board[][]){
    System.out.println("----------Chess Board-----------");
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board.length;j++){
            System.out.print(board[i][j]+" ");
        }
        System.out.println();
    }
}
public static void main(String[ ]args){
int n=4;
char board[][] =new char[n][n];
for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
        board[i][j]='x';
    }
}
nQueens(board, 0);
}

}