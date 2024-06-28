package 코딩테스트_연습;

import java.util.*;

public class ListHandle {
    public static void main(String[] args) {
        int[] temp = {5, 4, 3, 2, 1};
        Integer[] temp2 = Arrays.stream(temp).boxed().toArray(Integer[]::new);
        Arrays.sort(temp2, Collections.reverseOrder());
        System.out.println(temp[0]);


        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5));
        System.out.println(list);
        Set<Integer> set = new HashSet<>(list);
        System.out.println(set);
    }
}
