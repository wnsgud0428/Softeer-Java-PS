import java.util.HashMap;
import java.util.Map;

public class MapPractice {
    public static void main(String[] args) {

        int[] data = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};

        Map<Integer, Integer> map = new HashMap<>();
        for (int e : data) {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }

    }
}
