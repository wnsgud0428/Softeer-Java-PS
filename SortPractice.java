import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortPractice {
    
    public static void main(String[] args) {
        int[][] arr = new int[][]{{5, 40}, {3, 50}, {3, 30}, {3, 0}, {4, 20}, {2, 10}, {1, 100}};

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList();

        for (int i = 0; i < arr.length; i++) {
            ArrayList temp = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                temp.add(arr[i][j]);
            }
            arrayList.add(temp);
        }

        sortArray(arr);
        print2DArrayInline(arr);

        sortArrayList(arrayList);
        System.out.println(arrayList);

    }
    public static void sortArray(int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
    }

    public static void sortArrayList(ArrayList<ArrayList<Integer>> arrayList
    ) {
        Collections.sort(arrayList, (o1, o2) -> {
            if (o1.get(0) == o2.get(0))
                return o1.get(1) - o2.get(1);
            return o1.get(0) - o2.get(0);
        });
    }

    public static void print2DArrayInline(int[][] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j != array[i].length - 1) System.out.print(", ");
            }
            System.out.print("]");
            if (i != array.length - 1) System.out.print(", ");
        }
        System.out.print("]");
        System.out.println();
    }
}
