import java.util.*;

class Item{
    int weight = 0;
    int value = 0;
    public Item(int w, int v){
        this.weight = w; this.value = v;
    }

}

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        List<Item> items = new ArrayList<>();

        for(int i=0; i<weights.length; i++){
            Item item = new Item(weights[i], values[i]);
            items.add(item);
        }
        Collections.sort(items, (i1, i2) -> ((i2.value/i2.weight) - (i1.value/i1.weight)));

        for(Item item: items){            
            int minWeight = Math.min(capacity, item.weight);            
            capacity -= minWeight;            
            value += ((double)minWeight/item.weight)*item.value;
            if(capacity <= 0) break;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));

        scanner.close();
    }
} 
