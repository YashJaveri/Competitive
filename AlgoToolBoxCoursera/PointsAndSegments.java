import java.util.*;

class Point{
    int x = 0, index = 0;
    char type = 's';
    public Point(int x, int index, char type){
        this.x = x;
        this.index = index;
        this.type = type;
    }
}

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        List<Point> listOfPoints = new ArrayList<>();
        
        for(int i=0; i<starts.length; i++)
            listOfPoints.add(new Point(starts[i], i, 's'));
        for(int i=0; i<points.length; i++)
            listOfPoints.add(new Point(points[i], i, 'p'));
        for(int i=0; i<ends.length; i++)
            listOfPoints.add(new Point(ends[i], i, 'e'));
        
        Collections.sort(listOfPoints, (p1, p2)->{
            if(p1.x == p2.x)
            {
                if((p1.type == 's') || (p1.type == 'p' && p2.type == 'e'))
                    return -1;
                else if((p2.type == 's') || (p2.type == 'p' && p1.type == 'e'))
                    return 1;
            }
            return p1.x-p2.x;
        });
        int active = 0;
        for(Point p: listOfPoints){
            //System.out.println("Val: " + p.x + " type: " + p.type);
            if(p.type == 's')
                active++;
            else if(p.type == 'e')
                active--;
            else if(p.type == 'p')
                cnt[p.index] = active;
        }
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int i=0; i<cnt.length; i++) {
            if(i==cnt.length-1)
                System.out.print(cnt[i]);
            else
                System.out.print(cnt[i] + " ");
        }
    }
}