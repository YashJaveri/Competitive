import java.util.*;

public class Inversions {    
    static long merge(int a[], int temp[], int beg, int mid, int end) 
    {  
        int i=beg,j=mid,k,index = beg;
        long invCount = 0;
        
        while(i<mid && j<end)  
        {  
            if(a[i]<=a[j])  
                temp[index++] = a[i++];            
            else
            {
                temp[index++] = a[j++];
                invCount += (mid-i);
            }            
        }
        while(j<end)
                temp[index++] = a[j++];        
        while(i<mid)
                temp[index++] = a[i++];

        k = beg;  
        while(k<end)
        {  
            a[k]=temp[k];  
            k++;
        }
        return invCount;
    }

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        numberOfInversions += merge(a, b, left, ave, right);
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
        scanner.close();
    }
}

