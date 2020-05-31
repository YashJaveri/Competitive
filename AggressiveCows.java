/*Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).

His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
Input
t – the number of test cases, then t test cases follows.
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest minimum distance.*/

import java.util.*;

public class AggressiveCows {
    static ArrayList<Integer> inp;
    static int N, K;

    private static void print(Object s) {
        System.out.println(s.toString());
    }

    private static boolean fill(long gap) {
        long temp = 1;
        long prev = inp.get(0);

        for (int i = 1; i < N; i++) {
            if (inp.get(i) - prev >= gap) {
                temp++;
                if (temp == K)
                    return true;
                prev = inp.get(i);
            }
        }
        return false;
    }

    private static long algo(int K) {
        Collections.sort(inp);
        long initial = inp.get(0), last = inp.get(N - 1);
        long mid = (initial + last) / 2, max = 0;

        while (last > initial) {
            mid = (initial + last) / 2;
            if (fill(mid)) {
                if (mid > max)
                    max = mid;
                initial = mid + 1;
            } else
                last = mid;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        inp = new ArrayList<>();

        for (var l = 0; l < T; l++) {
            N = sc.nextInt();
            K = sc.nextInt();
            for (int j = 0; j < N; j++) {
                int x = sc.nextInt();
                inp.add(x);
            }
            long ans = algo(K);
            print(ans);
        }
        sc.close();
    }
}