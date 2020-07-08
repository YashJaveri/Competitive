import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) { 
        int distCanBeTravlled = tank, stations = 0, i =0;
        if(stops[0] > distCanBeTravlled)//Out of fuel in the start
            return -1;

        while(distCanBeTravlled < dist){
            if(i == 0)
            {
                if(stops[0] > distCanBeTravlled)//Out of fuel in the start
                    return -1;
            }
            else if(i<(stops.length-1) && stops[i+1]>distCanBeTravlled)//Out of fuel in between but not start
                return -1;
            else if(i == stops.length-1 && distCanBeTravlled<dist)//Out of fuel in the end
                return -1;
                        
            while(i<stops.length && distCanBeTravlled >= stops[i])                     
                i++;            
            
            i--;//Step back to refill            
            distCanBeTravlled = stops[i] + tank;//Refill            
            stations++;
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
