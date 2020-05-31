import java.io.*;
import java.util.*;

public class ExtraLongFactorial {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        List<Integer> ans = new ArrayList<>();
        int carry = 0, num = 0;

        for (int i = 0; i < 160; i++)
            ans.add(0);

        ans.set(0, 1);
        for (int i = 1; i <= n; i++) {
            carry = 0;
            for (int j = 0; j < ans.size(); j++) {
                num = i * ans.get(j) + carry;
                ans.set(j, num % 10);
                carry = num / 10;
            }
            ans.set(ans.size() - 1, carry);
        }

        int i=ans.size();
        for (i = ans.size() - 1; i >= 0; i--)
            if(ans.get(i) != 0)
                break;        

        for(int j=i; j>=0; j--)
            System.out.print(ans.get(j));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        extraLongFactorials(n);
        scanner.close();
    }
}
//https://www.hackerrank.com/challenges/extra-long-factorials/problem