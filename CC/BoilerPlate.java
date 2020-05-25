import java.util.*;

public class BoilerPlate {
    static ArrayList<Integer> inp;
    static int K, N;   


    private static void print(Object s){        
        System.out.println(s.toString());
    }

    private static void algo(){

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        inp = new ArrayList<>();

        for (int l = 0; l < T; l++) {
            N = sc.nextInt();
            K = sc.nextInt();
            for (int j = 0; j < N; j++) {
                int x = sc.nextInt();
                inp.add(x);
            }
            algo();
        }        
        sc.close();
    }
}