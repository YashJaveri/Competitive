import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    long prev = 0, curr = 1;
    long fibonac = 0;

    if(n == 0)
      return prev;
    if(n == 1)
      return curr;

    for(int i=0; i<n-1; i++)
    {
      fibonac = prev+curr;
      prev = curr;
      curr = fibonac;
    }

    return fibonac;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
    in.close();
  }
}
