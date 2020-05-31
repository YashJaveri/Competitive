import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        //write your code here
        List<Integer> aArr = new ArrayList<>(); List<Integer> bArr = new ArrayList<>();

        for(int i=0; i<a.length; i++)
        {
            aArr.add(a[i]);
            bArr.add(b[i]);
        }
        Collections.sort(aArr, Collections.reverseOrder()); Collections.sort(bArr, Collections.reverseOrder());        
        long result = 0;

        for (int i = 0; i < aArr.size(); i++)
            result += ((long)aArr.get(i))*bArr.get(i);
            
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
        scanner.close();
    }
}

