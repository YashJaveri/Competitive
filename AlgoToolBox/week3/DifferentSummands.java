import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        int current = 0, prize = 1, i = 0;     
        while(current!=n){
            if(n-current>=prize)
            {
                summands.add(prize);
                current += prize;
                i++;
                prize++;               
            }
            else
            {                
                summands.set(i-1, summands.get(i-1) + (n-current));
                current += n-current;
            }                
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

