import java.util.*;

public class MaximiseTheSum {
    static ArrayList<Integer> inp;
    static int K, N;   


    private static void print(Object s){        
        System.out.println(s.toString());
    }

    private static long algo(){
        List<Integer> arr = new ArrayList<>();

        if(inp.size()>=2*K)
        {
            for(int i=K-1; i>=0; i--)
                arr.add(inp.get(i));
            for(int i=0; i<K; i++)        
                arr.add(inp.get(inp.size()-1-i));
        }
        else if(inp.size() == K){
            long sum = 0;
            for (int i = 0; i < inp.size(); i++)
               sum = sum + inp.get(i);            
            return sum;            
        }
        else if(inp.size()<2*K && inp.size() != K){
            for(int i=K-1; i>=0; i--)
                arr.add(inp.get(i));
            for(int i=0; i<inp.size()-K; i++)        
                arr.add(inp.get(inp.size()-1-i));
        }

        //print(arr);

        long sum = 0, maxSoFar = 0;
        for(int i=0; i<K; i++)        
            sum += arr.get(i);
        maxSoFar = sum;

        for(int i=K; i<arr.size(); i++)
        {
            sum += arr.get(i);
            sum -= arr.get(i-K);
            if(sum>maxSoFar)
                maxSoFar = sum;
            //print("i: " + arr.get(i) + " sum: " + sum + "maxSoFor: " + maxSoFar);
        }

        return maxSoFar;
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        inp = new ArrayList<>();

        for (int l = 0; l < T; l++) {
            inp.clear();
            N = sc.nextInt();
            K = sc.nextInt();         
            for (int j = 0; j < N; j++) {
                int x = sc.nextInt();
                inp.add(x);
            }
            long ans = algo();
            print(ans);     
        }        
        sc.close();
    }
}