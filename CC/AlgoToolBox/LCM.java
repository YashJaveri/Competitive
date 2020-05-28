import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    long lcm = 1;
    if(a<b)
    {
      int temp = a;
      a = b;
      b = temp;
    }    
    for (long l = 1; l <= (long) b; ++l)
    {
      if ((l*a)%b == 0)
      {
        lcm = l*a;
        break;
      }    
    }
    return lcm;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
    scanner.close();
  }
}
