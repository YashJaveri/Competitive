import java.util.Scanner;

class MatrixMult{
    
    static int A[][], B[][], C[][];
    static int rA,cA,rB,cB;

public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of rows of matrix A:");
    rA=sc.nextInt();
    System.out.println("Enter number of columns of matrix B:");
    cB=sc.nextInt();
    System.out.println("Enter number of columns of matrix A/rows of matrix B:");
    cA=sc.nextInt();
    rB=cA;
    A=new int[rA][cA];
    B=new int[rB][cB];
    C=new int[rA][cB];
    emptyIt();
    display(false);
    System.out.println("Enter the matrix:");
    for(int i=0;i<rA;i++){
        for(int j=0;j<cA;j++){
            System.out.println("Enter row: " + i + " column " + j + " elemnt, for A");
            int x=sc.nextInt();
            A[i][j]=x;
            System.out.println();    
            display(false);
        }
    }
    for(int i=0;i<rB;i++){
        for(int j=0;j<cB;j++){
            System.out.println("Enter row: " + i + " column: " + j + " elemnt, for B");
            int x=sc.nextInt();
            B[i][j]=x;
            System.out.println();    
            display(false);
        }
    }  
    multiply();
    display(true);
 }

 static void display(Boolean answer){
     if(answer){
        for(int i=0;i<rA;i++){
            for(int j=0;j<cB;j++)
                System.out.print(C[i][j] + " ");
            System.out.println();    
        }
    }
    else{
    for(int i=0;i<rA;i++){
        for(int j=0;j<cA;j++)
            System.out.print(A[i][j] + " ");
        System.out.println();    
    }
    System.out.println();    
    for(int i=0;i<rB;i++){
        for(int j=0;j<cB;j++)
            System.out.print(B[i][j] + " ");
        System.out.println();   
    }  
  }
    System.out.println();    
 }

 static void emptyIt(){
    for(int i=0;i<rA;i++){
        for(int j=0;j<cA;j++)
           A[i][j]=0;   
    }
    System.out.println();    
    for(int i=0;i<rB;i++){
        for(int j=0;j<cB;j++)
            B[i][j]=0; 
    }  
 }
 static void multiply(){
     for(int i=0;i<rA;i++){
         for(int j=0;j<cB;j++){
             C[i][j]=0;
             for(int k=0;k<rB;k++){
                C[i][j]+=A[i][k]*B[k][j];
             }
         }
     }
 }
}