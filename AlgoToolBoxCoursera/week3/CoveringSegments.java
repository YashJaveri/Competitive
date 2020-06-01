import java.util.*;

public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
        Arrays.sort(segments);

        List<Integer> points = new ArrayList<>();
        int prev = segments[0].end;
        points.add(prev);        

    for (int i = 1; i < segments.length; i++) {
      if(!(segments[i].end>=prev && segments[i].start<=prev)) {
        prev = segments[i].end;        
        points.add(prev);
      }
    }
    return points;
    }

    private static class Segment implements Comparable<Segment>{
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Segment s){
            if(this.end > s.end) return 1;
            else if(this.end < s.end) return -1;            
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (Integer point : points) {
            System.out.print(point + " ");
        }
        scanner.close();
    }
}
 
