import java.io.*;
import java.util.*;

class PartyChairs{
    public static void main(String[] args) {
        int n;
        int[] arr, dept, duration;

        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        arr = new int[n];
        dept = new int[n];
        duration = new int[n];
        int x = 0, y = 0;

        for(int i=0; i<n; i++){
            x = sc.nextInt();
            arr[i] = x;
            y = sc.nextInt();
            duration[i] = y;
            dept[i] = arr[i] + duration[i];            
        }

        int i=1, j=0, numb = 1;
        Arrays.sort(arr); Arrays.sort(duration);
        while(i < n)
        {
            if(arr[i]<dept[j]){
                numb ++;
                j++;
            }
            i++;
        }                
        System.out.println(numb);
        
        sc.close();
    }    
}