import java.util.Scanner;;
  /* 1 2 3 4 5 6 7 
      2 3 4 5 6 7
       3 4 5 6 7
        4 5 6 7 
         5 6 7 
          6 7
           7 
          6 7 
         5 6 7 
        4 5 6 7 
       3 4 5 6 7 
      2 3 4 5 6 7
     1 2 3 4 5 6 7*/
public class Pattern1 {
    
    public static void main(String[] args) {
        int n = 7;
        int totalLines;

        System.out.println("Enter the number:");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        sc.close();

        totalLines = 2*n-1; 

        for (int i = 0; i < totalLines; i++) {
            if (i < n) {                      //for upper half
                for (int j = 0; j < i; j++)
                    System.out.print(" ");
                for (int j = i; j < n; j++)
                    System.out.print((j + 1) + " ");
            } else {                          //for lower half
                for(int j=0;j<(2*n-2)-i;j++)
                    System.out.print(" ");
                for(int j=0;j<i-n+2;j++)
                    System.out.print(totalLines-i+j + " ");
            }
            System.out.println();
        }
    }
}
