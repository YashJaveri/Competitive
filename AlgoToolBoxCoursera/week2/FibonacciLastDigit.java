import java.util.*;

public class FibonacciLastDigit {
    private static long getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long fib = 0;

        for (int i = 0; i < n - 1; ++i) {
            fib = (current + previous)%10;
            previous = current;
            current = fib;            
        }
        
        return fib % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

