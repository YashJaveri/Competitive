import java.util.*;

class SortByLargeNumb implements Comparator<String>{
    public int compare(String s1, String s2){
        if(Integer.valueOf(s1+s2) > Integer.valueOf(s2+s1))
            return -1;
        else if(Integer.valueOf(s1+s2) < Integer.valueOf(s2+s1))
            return 1;
        return 0;
    }
}

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        Arrays.sort(a, new SortByLargeNumb());
        for(String s: a)
            result += s;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
        scanner.close();
    }
}
