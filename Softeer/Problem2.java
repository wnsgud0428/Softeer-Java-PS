package Softeer;

import java.io.*;
import java.util.*;

public class Problem2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String operation = input[0];
        String secret_key = input[1];
        int rotate_num = Integer.parseInt(input[2]);
        String message = input[3];

        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 97);
            charAsNum.put(ch, i);
            NumAsChar.put(i, ch);
        }

        if (operation.equals("encrypt")) {
            int[] secret_int_arr = convertStringToNumberArray(secret_key);
            int[] message_int_arr = convertStringToNumberArray(message);
            int[] added_int_arr = addArray(secret_int_arr, message_int_arr);
            rotateLeft(added_int_arr, rotate_num);
            String encrypted = convertNumberArrayToString(added_int_arr);
            System.out.println(encrypted);
        } else if (operation.equals("decrypt")) {
            int[] message_int_arr = convertStringToNumberArray(message);
            rotateRight(message_int_arr, rotate_num);
            int[] secret_int_arr = convertStringToNumberArray(secret_key);
            int[] minused_int_arr = minusArray(message_int_arr, secret_int_arr);
            String decrypted = convertNumberArrayToString(minused_int_arr);
            System.out.println(decrypted);
        }

    }

    public static Map<Character, Integer> charAsNum = new HashMap<>();
    public static Map<Integer, Character> NumAsChar = new HashMap<>();

    public static int[] convertStringToNumberArray(String string) {
        int[] int_arr = new int[string.length()];

        for (int i = 0; i < string.length(); i++) {
            int_arr[i] = charAsNum.get(string.charAt(i));
        }

        return int_arr;
    }

    public static String convertNumberArrayToString(int[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += Character.toString(NumAsChar.get(arr[i]));
        }
        return result;
    }

    public static int[] addArray(int[] a, int[] b) {
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = (a[i] + b[i]) % 26;
        }

        return arr;
    }

    public static int[] minusArray(int[] a, int[] b) {
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = (a[i] - b[i]);
            if (arr[i] < 0) arr[i] += 26;
        }

        return arr;
    }

    public static void  rotateRight(int[] arr, int rotate_num) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            deque.add(arr[i]);
        }

        for (int i = 0; i < rotate_num; i++) {
            int v = deque.pollLast();
            deque.offerFirst(v);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = deque.pollFirst();
        }
    }

    public static void  rotateLeft(int[] arr, int rotate_num) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            deque.add(arr[i]);
        }

        for (int i = 0; i < rotate_num; i++) {
            int v = deque.pollFirst();
            deque.offerLast(v);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = deque.pollFirst();
        }
    }

//    numberToChar

//    CharToLetter
}