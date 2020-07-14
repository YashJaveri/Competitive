import java.util.*;
import java.lang.Math;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int[] value = w.clone();
        int[][] table = new int[w.length+1][W+1];
        
        for (int i = 0; i <= w.length; i++) {
          for(int j=0; j<=W; j++){
            if(i==0 || j==0)
              table[i][j] = 0;
            else if(j-w[i-1]<0)
              table[i][j] = table[i-1][j];
            else
              table[i][j] = Math.max(table[i-1][j], table[i-1][j-w[i-1]]+value[i-1]);
          }
        }
        return table[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];        
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

