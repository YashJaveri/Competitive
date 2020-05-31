import java.util.*;

public class FibonacciHuge {
    private static int getFibonacciHugeNaive(long n, int m) {
        int arr[] = new int[m*m+1];
        long period = 0;
        if (n <= 1)
            return (int)n;

        arr[0] = 0;
        arr[1] = 1;        

        for (int i = 0; i < m*m; i++) {
            arr[i+2] = (arr[i] + arr[i+1])%m;                
            if(arr[i+1] == 0 && arr[i+2] == 1)
            {                         
                period = i+1;
                break;
            }
        }
        return arr[(int)(n%period)];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

