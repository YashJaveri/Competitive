//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
import java.io.*;
import java.util.*;

public class Solution {
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int ans[] = new int[alice.length], ranks[] = new int[scores.length], pos[] = new int[scores.length];
        int num = scores[0], rank = 1;
        ranks[0] = rank;

        for (int i = 1; i < scores.length; i++) {
            if (num == scores[i])
                ranks[i] = rank;
            else {
                rank++;
                ranks[i] = rank;
                num = scores[i];
            }
        }

        for (int i = 0; i < alice.length; i++) {
            if (i > 0) {
                if (alice[i] <= scores[pos[i - 1]]) {
                    for (int j = pos[i - 1]; j < scores.length; j++) {
                        System.out.println("Less: " + scores[j] + " , alice: " + alice[i]);
                        if (alice[i] >= scores[j]) {
                            ans[i] = ranks[j];
                            break;
                        } else if (j == scores.length - 1)
                            ans[i] = ranks[scores.length - 1] + 1;
                        pos[i] = j;
                    }
                } else if (alice[i] > scores[pos[i - 1]]) {
                    for (int j = pos[i - 1]; j >= 0; j--) {
                        System.out.println("More: " + scores[j] + " , alice: " + alice[i]);
                        if (alice[i] < scores[j]) {
                            ans[i] = ranks[j] + 1;
                            break;
                        } else if (alice[i] == scores[j]) {
                            ans[i] = ranks[j];
                            break;
                        } else if (j == 0)
                            ans[i] = 1;
                        pos[i] = j;
                    }
                }
            } else {
                for (int j = 0; j < scores.length; j++) {
                    if (alice[i] >= scores[j]) {
                        ans[i] = ranks[j];
                        pos[i] = j;
                        break;
                    } else if (j == scores.length - 1)
                        ans[i] = ranks[scores.length - 1] + 1;
                    pos[i] = j;
                }
            }
        }
        return ans;
    }

    // By Hackerrank:
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        ///System.out.println("SCores COunt Actual: " + scoresItems.length);
        for (int i = 0; i < scoresItems.length; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }
        /*for (int i = 0; i < scoresCount; i++) {
            System.out.println(scores[i]);
        }*/
        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");

       // System.out.println("AliceCount: " + aliceCount);
        /*for (int i = 0; i < aliceCount; i++) {
            System.out.println(aliceItems[i]);
        }*/
        for (int i = 0; i < aliceItems.length; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        System.out.println(result);

        scanner.close();
    }
}
