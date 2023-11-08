

public class Pattern {

    public static void inverted_half_pyramid(int row){
        int i,j;
        
        for(i=1;i<=row;i++){

            for(j=1;j<=(row-i);j++){
                
                    System.out.print(" ");
               
            }
            for(j=1;j<=i;j++){
    System.out.print("*");

            }

            System.out.println();
            
        }
    }
    
   
public static void hollow_rectangle(int row,int col){
    int i,j;
    
    for(i=1;i<=row;i++){
        for(j=1;j<=col;j++){
            if(i==1||i==row||j==1||j==col){
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
public static void inverted_half_pyramid_numbers(int row){
    int i,j;
    for(i=1;i<=row;i++){
        for(j=1;j<=(row-i+1);j++){
            System.out.print(j);

        }
        for(j=1;j<=(i-1);j++){
            System.out.print(" ");
        }
        System.out.println();
    }
}
public static void floyds_triangle(int row){
int i,j;
int counter=1;
for(i=1;i<=row;i++){
    for(j=1;j<=i;j++){
        System.out.print(" "+counter);
        counter++;
    }
    System.out.println();
}
}
public static void zero_one_Triangle(int row){
int i,j;
for(i=1;i<=row;i++){
    for(j=1;j<=i;j++){
        if((i+j)%2==0){
            System.out.print("1");

        }
        else{
            System.out.print("0");
        }
    }
    System.out.println();
}
}
public static void butterfly(int row){
    int i,j;
    for(i=1;i<=row;i++){
        for(j=1;j<=i;j++){
            System.out.print("*");
        }
        for(j=1;j<=2*(row-i);j++){
            System.out.print(" ");
        }
        for(j=1;j<=i;j++){
            System.out.print("*");
        }
        System.out.println();
    }
    for(i=row;i>=1;i--){
        for(j=1;j<=i;j++){
            System.out.print("*");
        }
        for(j=1;j<=2*(row-i);j++){
            System.out.print(" ");
        }
        for(j=1;j<=i;j++){
            System.out.print("*");
        }
        System.out.println();
    }
}
public static void solid_rhombus(int row){
    int i,j;
    for(i=1;i<=row;i++){
        for(j=1;j<=(row-i);j++){
            System.out.print(" ");
        }
        for(j=1;j<=row;j++){
            System.out.print("*");
        }
        System.out.println();
    }
}
public static void hollow_rhombus(int row){
    int i,j;
    for(i=1;i<=row;i++){
        for(j=1;j<=(row-i);j++){
            System.out.print(" ");
        }
        for(j=1;j<=row;j++){
            if(i==1||i==row||j==1||j==row){
                System.out.print("*");
            }  
            else{
                System.out.print(" ");
            }     
         }
         System.out.println();
    }
}
public static void diamond(int row){
    int i,j;
    for(i=1;i<=row;i++){
        for(j=1;j<=(row-i);j++){
            System.out.print(" ");
        }
        for(j=1;j<=(2*i)-1;j++);
        {
            System.out.print("*");
        }
        System.out.println();
    }
    for(i=row;i>=1;i--){
        for(j=1;j<=(row-i);j++){
            System.out.print(" ");
        }
        for(j=1;j<=(2*i)-1;j++);
        {
            System.out.print("*");
        }
        System.out.println();
    }
}

    public static void main(String args[]){

      //hollow_rectangle(4,5);
      //hollow_rhombus(5);
      diamond(4);

    }
}

