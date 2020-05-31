import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) { 
        int distCanBeTravlled = tank, stations = 0, i =0;
        while(distCanBeTravlled < dist){            
            if(i<(stops.length-1) && stops[i+1]>distCanBeTravlled)//Cant travel
                return -1;
                        
            while(i<stops.length && distCanBeTravlled >= stops[i])
            {
                //System.out.println("Skipping: " + stops[i]);
                i++;
            }
            i--;//Step back to refill
            //System.out.println("Gng back to: " + stops[i]);
            distCanBeTravlled = stops[i] + tank;//Refill
            //System.out.println("DistCan: " + distCanBeTravlled);
            stations++;
            if(i == stops.length-1 && distCanBeTravlled<dist)
                return -1; 
        }
        return stations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
        scanner.close();
    }
}
