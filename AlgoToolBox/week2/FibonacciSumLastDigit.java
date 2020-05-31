import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSum(long n, int m) {
        int arr[] = new int[m*m+1];
        long period = 0;
        long sum = 1;
        if (n <= 1)
            return (int)n;

        arr[0] = 0;
        arr[1] = 1;        

        for (int i = 0; i < m*m; i++) {
            arr[i+2] = (arr[i] + arr[i+1])%m;
            sum+=arr[i+2];
            sum = sum%m;           
            if(arr[i+1] == 0 && arr[i+2] == 1)
            {                         
                period = i+1;
                if(sum<0) sum=m;
                break;
            }
        }
            long finalSum = ((n/period)*sum)%m;
            long remain = n%period;

            for(long i=0; i<=remain; i++)
            {
                finalSum += arr[(int)i];
                finalSum = finalSum%m;
            }        
        return finalSum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n, 10);
        System.out.println(s);
    }
}

