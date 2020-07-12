import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        byte[] dpArr = new byte[n+1];
        dpArr[1] = 0; dpArr[2] = 1; dpArr[3] = 1;

        for(int i=4; i<=n; i++){            
            byte min = (byte)(dpArr[i-1] + 1);
            if(i%3==0){
                if((dpArr[(int)i/3]+1)<min)
                    min = (byte)(dpArr[(int)i/3]+1);
                //System.out.println(i + ": " + dpArr[(int)i]);
            }
            if(i%2==0){
                if((dpArr[(int)i/2]+1)<min)
                    min = (byte)(dpArr[(int)i/2]+1); 
            }
            dpArr[i] = min;
        }
        
        for(int i=1; i<dpArr.length; i++)
            System.out.println(i + ": " + dpArr[i]);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
        scanner.close();
    }
}

