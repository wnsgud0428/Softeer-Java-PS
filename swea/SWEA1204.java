package swea;

import java.util.*;

public class SWEA1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {
            int tc = Integer.parseInt(sc.nextLine());
            int[] scores = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            Map<Integer, Integer> score_count = new HashMap<>();
            for (int score : scores) {
                if (score_count.containsKey(score)) {
                    score_count.put(score, score_count.get(score) + 1);
                } else {
                    score_count.put(score, 1);
                }
            }

            ArrayList<ArrayList<Integer>> score_list = new ArrayList<>();
            for (int key : score_count.keySet()) {
                score_list.add(new ArrayList<>(Arrays.asList(key, score_count.get(key))));
            }
//            System.out.println(score_list);

            sortArrayList(score_list);
//            System.out.println(score_list);
            int answer = score_list.get(0).get(0);
            System.out.println("#" + tc + " " + answer);


//            System.out.println(Arrays.toString(scores));
        }

    }

    public static void sortArrayList(ArrayList<ArrayList<Integer>> arrayList
    ) {
        Collections.sort(arrayList, (o1, o2) -> {
            if (o1.get(1) == o2.get(1))
                return o2.get(0) - o1.get(0);
            return o2.get(1) - o1.get(1);
        });
    }
}
