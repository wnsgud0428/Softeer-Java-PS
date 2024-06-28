import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapPractice {
    public static void main(String[] args) {

        String[] data = {"a", "a", "b", "c", "d", "d", "d"};

        Map<String, Integer> map = new HashMap<>();
        for (String e : data) {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }

        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

    }
}
