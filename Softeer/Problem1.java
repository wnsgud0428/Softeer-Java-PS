package Softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] numbers = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt).toArray();
        String[] string_numbers = br.readLine().split(" ");
        //  조건 만족 안되는 입력 -> -1 출력!!!!!

        permutation(string_numbers, 0, string_numbers.length, string_numbers.length);
//        System.out.println(out2);

        ArrayList<Integer> values = new ArrayList<>();
        for (String[] string_arr : out2) {
            int num = Integer.parseInt(String.join("", string_arr));
            values.add(num);
        }

        System.out.println(Collections.max(values)+Collections.min(values));





        /*
        최대9개

         */

    }
    public static ArrayList<String[]> out2 = new ArrayList<>();

    // permutation 코드 출처: https://bcp0109.tistory.com/14
    public static void permutation(String[] arr, int depth, int n, int r) {

        if (depth == r) {
//            print(arr, r);
            String[] temp = Arrays.copyOf(arr, arr.length);
            out2.add(temp);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }


    }

    public static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    // 배열 출력
    public static void print(String[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
