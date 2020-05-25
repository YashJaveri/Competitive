/*I being a Noob thought of a very simple problem.

Given 2 histograms as an input in the form of arrays of N and M elements. (M <= N)

Find out at how many places can I place smaller histogram over larger histogram so that the upper part of the histograms exactly match up.

Input

First-line contains two integers N and M.

Second-line contains N integers representing the larger histogram

The third line contains M integers representing the smaller histogram*/

import java.util.*;
import java.lang.*;

public class SimpleNoob {
    //static ArrayList<Integer> nInp, mInp, 
    static String diffnInp = "", diffmInp = "";
    static int N, M;

    private static void print(Object s){        
        System.out.println(s.toString());
    }

    static int KMPSearch(String pat, String txt) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
   
        // create lps[] that will hold the longest 
        // prefix suffix values for pattern 
        int lps[] = new int[M]; 
        int j = 0;  // index for pat[] 
   
        // Preprocess the pattern (calculate lps[] 
        // array) 
        computeLPSArray(pat,M,lps); 
   
        int i = 0;  // index for txt[] 
        int res = 0;  
        int next_i = 0;   
          
        while (i < N) 
        { 
            if (pat.charAt(j) == txt.charAt(i)) 
            { 
                j++; 
                i++; 
            } 
            if (j == M) 
            { 
                // When we find pattern first time, 
                // we iterate again to check if there  
                // exists more pattern 
                j = lps[j-1]; 
                res++; 
  
                // We start i to check for more than once 
                // appearance of pattern, we will reset i  
                // to previous start+1 
                if (lps[j]!=0) 
                    i = ++next_i; 
                j = 0; 
            } 
   
            // mismatch after j matches 
            else if (i < N && pat.charAt(j) != txt.charAt(i)) 
            { 
                // Do not match lps[0..lps[j-1]] characters, 
                // they will match anyway 
                if (j != 0) 
                    j = lps[j-1]; 
                else
                    i = i+1; 
            } 
        } 
        return res; 
    } 
   
    static void computeLPSArray(String pat, int M, int lps[]) 
    { 
        // length of the previous longest prefix suffix 
        int len = 0; 
        int i = 1; 
        lps[0] = 0;  // lps[0] is always 0 
   
        // the loop calculates lps[i] for i = 1 to M-1 
        while (i < M) 
        { 
            if (pat.charAt(i) == pat.charAt(len)) 
            { 
                len++; 
                lps[i] = len; 
                i++; 
            } 
            else  // (pat[i] != pat[len]) 
            { 
                // This is tricky. Consider the example. 
                // AAACAAAA and i = 7. The idea is similar  
                // to search step. 
                if (len != 0) 
                { 
                    len = lps[len-1]; 
   
                    // Also, note that we do not increment 
                    // i here 
                } 
                else  // if (len == 0) 
                { 
                    lps[i] = len; 
                    i++; 
                } 
            } 
        } 
    } 

    private static int algo(){
        //print("Diff: " + diffnInp);
        //print("Diff: " + diffmInp);
        /*print("Inp: " + nInp);
        print("mInp: " + mInp);*/
        /*int count = 0;
        boolean completely = true;

        int i=0;
        while(i<=(diffnInp.size()-diffmInp.size())){
            if(diffnInp.get(i).equals(diffmInp.get(0)))
            {
                completely = true;
                i++;
                int revert_i = i;
                for(int j=1; j<diffmInp.size(); j++){
                    if(diffmInp.get(j).equals(diffnInp.get(i)))                    
                        i++;
                    else
                    {
                        completely = false;
                        break;
                    }                        
                }
                if(completely)
                    count++;
                i = revert_i;                     
            }
            else
                i++;     
        }*/

        return 0;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        

        N = sc.nextInt();
        M = sc.nextInt();

        int x = 0, prev = 0;
        for(int j = 0; j < N; j++) {
            if(j==0)            
                x = sc.nextInt();
            if(j!=0){
                prev = x;
                x = sc.nextInt();
                diffnInp += String.valueOf(x-prev);
            }
        }
        x = 0; prev = 0;
        for(int j = 0; j < M; j++) {
            if(j==0)    
                x = sc.nextInt();
            if(j!=0){
                prev = x;
                x = sc.nextInt();
                diffmInp += String.valueOf(x-prev);
            }
        }
        
        int ans = KMPSearch(diffmInp, diffnInp);
        print(ans);      
        sc.close();
    }
}