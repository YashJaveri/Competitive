import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        int arr[] = new int[61];
        long psum = 1;        
        arr[0] = 0;
        arr[1] = 1;        

        for (int i = 0; i <= 60; i++){            
            arr[i+2] = (arr[i] + arr[i+1])%10;
            psum += arr[i+2];
        }

        long finalSum = 0;

        if(to < 60)
            for(long i=from; i<=to; i++) finalSum = ( finalSum + arr[(int)i] )%10;
        else{
            int prod = n/60;
            from = from%60;
            to = to%60;
            for(long i=from; i<=60; i++) finalSum = ( finalSum + arr[(int)i] )%10;
            for(long i=1; i<=to; i++) finalSum = ( finalSum + arr[(int)i] )%10; 
        } 
        return finalSum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

