/*Avery has an array of N positive integers. The i-th integer of the array is Ai.

A contiguous subarray is an m-countdown if it is of length m and contains the integers m, m-1, m-2, ..., 2, 1 in that order. For example, [3, 2, 1] is a 3-countdown.

Can you help Avery count the number of K-countdowns in her array?*/
import java.util.*;

class Countdown_Kickstart{    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();        
        int count = 0, finalCount=0;

        for(int l=0; l<T; l++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            for(int j=0; j<N; j++){
                int x = sc.nextInt();
                arr.add(x);            
            }
            int i=0;
            while(i<=N-K){
                if(arr.get(i) == K)
                {
                    i++;
                    count = 1;
                    while(i<N && arr.get(i-1)-1==arr.get(i))
                    {
                        i++;
                        count++;
                    }
                    //System.out.println("Count: " + count);
                    if(count == K)
                        finalCount++;
                }
                else
                    i++;
            }
            System.out.println(finalCount);
            arr.clear();
            finalCount = 0; count = 0;                   
        }
        sc.close();
    }
}