import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int coins[] = {1, 3, 4};
        int dpArr[] = new int[m+1];
        dpArr[0] = 0;

        for(int i=1; i<=m; i++){            
            dpArr[i] = Integer.MAX_VALUE;
            for(int coin:coins){
                if((i-coin)>=0 && ((dpArr[i-coin]+1)<dpArr[i])){
                    dpArr[i] = dpArr[i-coin]+1;
                }
            }
        }
        return dpArr[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}