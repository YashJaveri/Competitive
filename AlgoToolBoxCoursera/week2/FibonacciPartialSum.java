import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        int arr[] = new int[60];
        long psum = 1;        
        arr[0] = 0;
        arr[1] = 1;        

        for (int i = 0; i < 58; i++){            
            arr[i+2] = (arr[i] + arr[i+1])%10;
            psum += arr[i+2];            
        }                

        long finalSum = 0;
        long period = 60;

        if((to/period) == (from/period))
        {            
            from = from%period;
            to = to%period;
            for(int i=(int)from; i<=(int)to; i++) finalSum = ( finalSum + arr[i] )%10;
        }
        else{
            long x = (to/period) - (from/period) - 1;            
            finalSum = (finalSum + psum*x)%10;
            from = from%period;
            to = to%period;            
            for(int i=(int)from; i<60; i++) finalSum = ( finalSum + (long)arr[i] )%10;
            for(int i=0; i<=(int)to; i++) finalSum = ( finalSum + (long)arr[i] )%10; 
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

