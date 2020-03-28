import java.util.*;

class RatInTheMaze {
    static boolean flag = false;
    static int[][] inp = new int[20][20];
    static boolean[][] visited = new boolean[20][20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        int row9 = 0, col9 = 0;

        for (int i = 0; i < limit; i++)
            for (int j = 0; j < limit; j++)
                inp[i][j] = sc.nextInt();

        System.out.println("Input: ");
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                System.out.print(inp[i][j] + " ");
                if (inp[i][j] == 9) {
                    row9 = i;
                    col9 = j;
                }
            }
            System.out.println();
        }

        backTracker(row9, col9, limit);
        if(flag)
            System.out.println("Yes");
        else
            System.out.println("No");

        sc.close();
    }

    private static void backTracker(int r, int c, int limit) {
        visited[r][c] = true;

        if (r == 0 && c == 0) {
            flag = true;
            return;
        }
        else if(!flag){
            if(r+1<limit && !visited[r+1][c] && inp[r+1][c] == 1)
                backTracker(r+1, c, limit);
            if(c+1<limit && !visited[r][c+1] && inp[r][c+1] == 1)            
                backTracker(r, c+1, limit);
            if(c-1>=0 && !visited[r][c-1] && inp[r][c-1] == 1)
                backTracker(r, c-1, limit);
            if(r-1>=0 && !visited[r-1][c] && inp[r-1][c] == 1)
                backTracker(r-1, c, limit);
        }
    }
}