import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        int arr[] = new int[60], sqrs[] = new int[60];
        long period = 60;
        long sumSqr = 1;

        if (n <= 1)
            return (int)n;

        arr[0] = 0; arr[1] = 1; 
        sqrs[0]=0; sqrs[1]=1;

        for (int i = 0; i < 58; i++) {
            arr[i+2] = (arr[i] + arr[i+1])%10;
            sqrs[i+2] = arr[i+2]*arr[i+2];                    
            sumSqr = (sumSqr + sqrs[i+2])%10;                        
        }        
            long finalSum = ((n/period)*sumSqr)%10;            
            long remain = n%period;            
            for(int i=0; i<=remain; i++)
                finalSum = (finalSum + sqrs[i])%10;
        return finalSum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}

