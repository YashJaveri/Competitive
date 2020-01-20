import java.util.*;

class Outer {
    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare == 0)
                    return 1;
                else
                    return compare;
            }
        };

        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    void test() {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        map.put("A", 3);
        map.put("B", 2);
        map.put("C", 1);

        // Get an iterator
        Map sortedMap = sortbByValues(map);
        Iterator i = sortedMap.entrySet().iterator();

        // Display elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
    }

}