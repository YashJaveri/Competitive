import java.lang.*;
import java.util.*;

public class MaxProd {

    public static void main(String[] args) {
        Integer arr[] = { 5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9 };
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i : arr)
            list.add(i);

        Solution sol = new Solution();

        int a = sol.maxSpecialProduct(list);
        System.out.println(a);
    }
}

class Solution {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        ArrayList<Integer> ls = new ArrayList<>(), rs = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        long max = 0, res = 0;

        for (int i = 0; i < A.size(); i++) {
            while (!s.empty() && A.get(s.peek()) <= A.get(i))
                s.pop();

            if (s.empty())
                ls.add(0);
            else
                ls.add(s.peek());
            s.push(i);
        }
        s.clear();

        for (int i = A.size() - 1; i >= 0; i--) {
            while (!s.empty() && A.get(s.peek()) <= A.get(i))
                s.pop();

            if (s.empty())
                rs.add(0);
            else
                rs.add(s.peek());
            s.push(i);
        }

        for (int i = 0; i < A.size(); i++) {
            res = (long) ls.get(i) * (long) rs.get(A.size() - 1 - i);
            if (max < res) {
                max = res;
            }
        }

        return (int) (max % 1000000007);
    }
}
//