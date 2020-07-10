import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();    

    private static int[] partition3(int[] a, int l, int r) {      
        int m1 = l, m2 = r;
        int i = l-1, j = r;
        int p = l-1, q = r; 
        int pivot = a[r], temp = 0;

        while (true) 
        { 
            //Go on till element is less than pivot(left)
            while (a[++i] < pivot); 
            
            //Go on till element is more than pivot(right)
            while (pivot < a[--j])
                if (j == l)
                    break;

            // If i and j cross, then we are done
            if (i >= j) break; 

            // Swap if condition not satisfied
            temp=a[i]; a[i]=a[j]; a[j]=temp;

            //Swap if equal
            if (a[i] == pivot)
            { 
                p++;//Last index of equals
                temp=a[i]; a[i]=a[p]; a[p]=temp;
            }

            //Swap if equal
            if (a[j] == pivot)
            {
                q--;//First index of equals
                temp=a[j]; a[j]=a[q]; a[q]=temp;
            }
        } 

        // Move pivot element to its correct index 
        temp=a[i]; a[i]=a[r]; a[r]=temp;

        // Move all left same occurrences from beginning to adjacent to arr[i] 
        j = i-1; 
        for (int k = l; k < p; k++){
            temp=a[j]; a[j]=a[k]; a[k]=temp;
            j--;
        }

        // Move all right same occurrences from end 
        // to adjacent to arr[i] 
        i = i+1; 
        for (int k = r-1; k > q; k--){            
            temp=a[i]; a[i]=a[k]; a[k]=temp;
            i++;            
        }
        m1=j; m2=i;
        int[] m = {m1, m2};
        return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0]);
        randomizedQuickSort(a, m[1], r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

