import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        byte coinsAvail[] = {10, 5, 1};
        int coinCount = 0;

        for(int i=0; i<coinsAvail.length; i++){
           coinCount += m/coinsAvail[i];
           m = m%coinsAvail[i];
        }
        return coinCount ;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

        scanner.close();
    }
}

