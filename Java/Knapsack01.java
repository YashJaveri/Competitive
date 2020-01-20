// Java code for Dynamic Programming based 
// solution for 0-1 Knapsack problem 

class UnboundedKnapsack01 {

    static void printknapSack(int W, int wt[], int val[], int n) {
        int i, w, x;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w) {
                    if (w % wt[i - 1] == 0 && w / wt[i - 1] != 1) {
                        x = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                        K[i][w] = Math.max(x, (w / wt[i - 1]) * val[i - 1]);
                    } else
                        K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else
                    K[i][w] = K[i - 1][w];
            }
        }

        // stores the result of Knapsack
        int res = K[n][W];
        System.out.println(res);

        w = W;
        for (i = n; i > 0 && res > 0; i--) {

            if (res == K[i - 1][w])
                continue;
            else {

                if (val[i - 1] % K[i - 1][w] == 0 && val[i - 1] / K[i - 1][w] != 1
                        && (w / wt[i - 1]) * val[i - 1] == K[i - 1][w]) {
                    for (int j = 0; j < (int)(w / wt[i - 1]); j++)
                        System.out.print(wt[i - 1] + " ");
                        res = res - (int)(w / wt[i - 1]) * val[i - 1];
                        w = 0;
                } else
                    // This item is included.
                    System.out.print(wt[i - 1] + " ");

                // Since this weight is included its
                // value is deducted
                res = res - val[i - 1];
                w = w - wt[i - 1];
            }
        }
    }

    // Driver code
    public static void main(String arg[]) {
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;
        int n = val.length;

        printknapSack(W, wt, val, n);
    }
}

// This code is contributed by Anant Agarwal.