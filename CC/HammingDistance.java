import java.util.*;

public class HammingDistance{
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> ls = new ArrayList<>();
        ls.add(2);
        ls.add(4);
        ls.add(6);            
        int a = sol.hammingDistance(ls);
        System.out.println(a);
    }
}

class Solution {
    public int hammingDistance(final List<Integer> A) {
        int n = A.size();
        int dist = 0;
        for(int i = 0; i < 31; i++) {
            int oneCount = 0;
            for(int j = 0; j < n; j++) {
                int num = A.get(j);
                oneCount += (num & 1 << i) != 0? 1 : 0;
            }
            int zeroCount = n - oneCount;
            dist += (2L * oneCount * zeroCount) % 1000000007;
            dist = dist % 1000000007;
        }
        return dist;
    }
}
//https://www.interviewbit.com/problems/largest-number/