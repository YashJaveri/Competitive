import java.util.*;
  
class Interval 
{ 
    int start,end; 
    Interval(int start, int end) 
    { 
        this.start=start; 
        this.end=end; 
    } 
} 

public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> result = new ArrayList<>(), intervals = new ArrayList<>();
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(6, 8));

        result = new Solution().insert(intervals, new Interval(1, 12));
        for (int i = 0; i < result.size(); i++)
            System.out.print("(" + result.get(i).start + ", " + result.get(i).end + ")");
    }
}

class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        if (intervals.size() == 0 || intervals.size() == 1) {
            intervals.add(newInterval);
            return intervals;
        }

        intervals.add(newInterval);
        Collections.sort(intervals, (i1, i2) -> {
            return i1.start - i2.start;
        });

        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;

        ArrayList<Interval> result = new ArrayList<>();

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);

            // System.out.println(current.start);
            // System.out.println(end);

            if (current.start <= end) {
                end = Math.max(current.end, end);
                if (i == intervals.size() - 1)
                    result.add(new Interval(start, end));
            } else {
                result.add(new Interval(start, end));
                start = current.start;
                end = current.end;
                if (i == intervals.size() - 1)
                    result.add(new Interval(start, end));
            }
        }

        return result;
    }
}
//https://www.interviewbit.com/problems/merge-intervals/