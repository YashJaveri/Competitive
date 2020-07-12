import java.util.*;

class Numb{
    byte minWays;
    char factor;
    public Numb(byte minWays, char factor){
        this.minWays = minWays;
        this.factor = factor;
    }
}

public class PrimitiveCalculatorWithFactors {
    private static Stack<Integer> optimal_sequence(int n) {
        List<Numb> sequence = new ArrayList<>(n+1);
        sequence.add(new Numb((byte) 0, '0'));
        sequence.add(new Numb((byte) 0, '1'));
        sequence.add(new Numb((byte) 1, '2'));
        sequence.add(new Numb((byte) 1, '3'));      

        for(int i=4; i<=n; i++){     
            byte min = (byte)(sequence.get(i-1).minWays + 1);
            char factor = '1';

            if(i%2==0){
                if((sequence.get(i/2).minWays + 1)<min){
                    min = (byte)(sequence.get(i/2).minWays + 1);
                    factor = '2';
                }
            }
            if(i%3==0){
                if((sequence.get(i/3).minWays + 1)<min)
                {
                    min = (byte)(sequence.get(i/3).minWays + 1);
                    factor = '3';
                }
            }
            sequence.add(new Numb(min, factor));
        }
        
        Stack<Integer> ans = new Stack<>();
        int x = n;
        while(x>0){
            //System.out.println(x + ": " + sequence.get(x).minWays + " factor: " + sequence.get(x).factor);
            ans.push(x);
            if(x == 1)                   
                break;            
            if(sequence.get(x).factor == '1')       
                x = x-1;            
            else if(sequence.get(x).factor == '2')            
                x = x/2;            
            else if(sequence.get(x).factor == '3')            
                x = x/3;            
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
        scanner.close();
    }
}

