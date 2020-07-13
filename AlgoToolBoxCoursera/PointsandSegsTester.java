import java.util.*;

class TestPoint{
    int x = 0, index = 0;
    char type = 's';
    public TestPoint(int x, int index, char type){
        this.x = x;
        this.index = index;
        this.type = type;
    }
}

public class PointsandSegsTester {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        List<TestPoint> listOfPoints = new ArrayList<>();
        
        for(int i=0; i<starts.length; i++)
            listOfPoints.add(new TestPoint(starts[i], i, 's'));
        for(int i=0; i<points.length; i++)
            listOfPoints.add(new TestPoint(points[i], i, 'p'));
        for(int i=0; i<ends.length; i++)
            listOfPoints.add(new TestPoint(ends[i], i, 'e'));
        
        Collections.sort(listOfPoints, (p1, p2)->{
            if(p1.x == p2.x)
            {
                if((p1.type == 's') || (p1.type == 'p' && p2.type == 'e'))
                    return 0;
                else if((p2.type == 's') || (p2.type == 'p' && p1.type == 'e'))
                    return 1;
            }
            return p1.x-p2.x;
        });
        int active = 0;
        for(TestPoint p: listOfPoints){
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
        Random rand = new Random();
     
        for(int k=0; k<1000; k++)
        {            
            n = 1+rand.nextInt(5000);
            m = 1+rand.nextInt(5000);

            int[] starts = new int[n];
            int[] ends = new int[n];
            int[] points = new int[m];

            int min = -100000000, max = 100000000;
            for (int i = 0; i < n; i++) {            
                starts[i] = min+rand.nextInt((max-min)+1);
                ends[i] = starts[i]+rand.nextInt((max-starts[i])+1);
            }
            for (int i = 0; i < m; i++) {
                points[i] = min+rand.nextInt((max-min)+1);
            }
            //use fastCountSegments
            int[] cntFast = fastCountSegments(starts, ends, points);
            int[] cntSlow = naiveCountSegments(starts, ends, points);
            boolean failed = false;
            for (int i=0; i<cntFast.length; i++) {
                if(cntFast[i] != cntSlow[i]){
                    System.out.println("\nTest case failed for:");
                    for(int j=0; j<n; j++)
                    {
                        System.out.print("("+starts[j]+", "+ends[j]+"), ");                    
                    }
                    System.out.println("\n");
                    System.out.println("Points: "+Arrays.toString(starts));
                    failed = true;
                    break;
                }
            }
            if(failed) break;                    
        }
    }
}

