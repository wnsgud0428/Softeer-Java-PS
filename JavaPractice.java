import java.util.*;

public class JavaPractice {
    public static void main(String[] args) {
        int[] scores = Arrays.stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();
    }
}
