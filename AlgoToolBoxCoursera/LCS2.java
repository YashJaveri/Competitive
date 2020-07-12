import java.util.*;
import java.lang.Math;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        int dpMat[][] = new int[b.length+1][a.length+1];

        for(int i=0; i<=b.length;i++){
            for(int j=0;j<=a.length;j++){
                if(i==0 || j==0)
                    dpMat[i][j] = 0;
                else if(b[i-1] == a[j-1])
                    dpMat[i][j] = dpMat[i-1][j-1] + 1;
                else
                    dpMat[i][j] = Math.max(dpMat[i-1][j], dpMat[i][j-1]);
            }
        }
        return dpMat[b.length][a.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
        scanner.close();
    }
}

