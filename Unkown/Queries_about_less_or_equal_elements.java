/*
You are given two arrays of integers a and b. For each element of the second array b j you should find the number of elements in array a that are less than or equal to the value b j.
Input
The first line contains two integers n, m (1 ≤ n, m ≤ 2·105) — the sizes of arrays a and b.
The second line contains n integers — the elements of array a ( - 109 ≤ a i ≤ 109).
The third line contains m integers — the elements of array b ( - 109 ≤ b j ≤ 109).

Output
Print m integers, separated by spaces: the j-th of which is equal to the number of such elements in array a that are less than or equal to the value b j.*/

import java.util.*;

public class Queries_about_less_or_equal_elements{
    static ArrayList<Long> inp1, inp2;
    static int n, m;


    private static void print(Object s){        
        System.out.println(s.toString());
    }

    private static int binarySearch(int min, int max, long num){
        int mid = (min + (max-min)/2);        
        //print(mid);
        if(inp1.size() == 1)
            return num>=inp1.get(mid)?1:0;
        if(inp1.get(mid) == num){            
            mid+=1;
            while(mid<inp1.size() && inp1.get(mid)==num)
                mid++;
            return mid;
        }
        else if(inp1.get(mid) < num && (mid+1) < inp1.size() && inp1.get(mid+1) > num)
            return mid+1;
        else if(inp1.get(mid) > num){
            if(mid==1){
                if (inp1.get(mid-1) > num)
                    return 0;
            }
            return binarySearch(min, mid, num);
        }            
        else if(inp1.get(mid) < num){
            if(mid == inp1.size()-2){
                if(inp1.get(mid+1) <= num)
                    return inp1.size();
            }
            return binarySearch(mid, max, num);
        }
        return 0;    
    }

    private static void algo(){
        Collections.sort(inp1);
        //print(inp1);

        for(int i=0; i<inp2.size(); i++){
            int index = binarySearch(0, inp1.size()-1, inp2.get(i));
            if(i==inp2.size()-1)
                System.out.print(index);
            else
                System.out.print(index + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inp1 = new ArrayList<>(); inp2 = new ArrayList<>();
        n = sc.nextInt();
        m = sc.nextInt(); 

        for (int j = 0; j < n; j++) {
            long x = sc.nextInt();
            inp1.add(x);
        } 
        for (int j = 0; j < m; j++) {
            long x = sc.nextInt();
            inp2.add(x);
        }
        algo();
        sc.close();
    }
}