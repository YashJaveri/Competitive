import java.util.*;

public class LargestNumber{
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> ls = new ArrayList<>();
        ls.add(3);
        ls.add(30);
        ls.add(34);
        ls.add(5);
        ls.add(9);
        String s = sol.largestNumber(ls);
        System.out.println(s);
    }
}

class Solution {
    
    public String largestNumber(final List<Integer> A) {
        ArrayList<String> cop = new ArrayList<>();
        for(int i=0; i<A.size(); i++)
            cop.add(String.valueOf(A.get(i)));
        
        cop.sort((s1, s2)->{
            String first = s1 + s2;
            String second = s2 + s1;
            
            return second.compareTo(first);
        });
        StringBuffer s1 = new StringBuffer();
        
        for(String str: cop){
            if(str.equals("0")){
                if(s1.length() == 0)
                    s1.append(str);
                else if(!(Character.toString(s1.charAt(0))).equals("0"))
                    s1.append(str);
                continue;
            }
            s1.append(str);
        }
            
        return s1.toString();
    }
}
//https://www.interviewbit.com/problems/largest-number/