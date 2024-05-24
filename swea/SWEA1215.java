package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(sc.nextLine());
            String[][] board = new String[8][8];

            for (int i = 0; i < 8; i++) {
                board[i] = sc.nextLine().split("");
            }


            int count = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8-(N-1); j++) {
                    // 가로로 String 배열 뽑아내기
                    String[] sliced = new String[N];
                    for (int k = 0; k < N; k++) {
                        sliced[k] = board[i][j+k];
                    }
                    // palindorme 인지 검사
                    if (isPalindrome(sliced))
                        count += 1;
                }
            }
//            System.out.println(count);

            for (int i = 0; i < 8-(N-1); i++) {
                for (int j = 0; j < 8; j++) {
                    // 세로로 String 배열 뽑아내기
                    String[] sliced = new String[N];
                    for (int k = 0; k < N; k++) {
                        sliced[k] = board[i+k][j];
                    }
                    // palindorme 인지 검사
                    if (isPalindrome(sliced))
                        count += 1;
                }
            }
            System.out.println("#"+test_case+" "+count);


            //////////////////////////////////////
        }
    }

    public static boolean isPalindrome(String[] stringArr) {
        int n = stringArr.length;
        for (int i = 0; i < n/2; i++) {
            if (!stringArr[i].equals(stringArr[n-1-i]))
                return false;
        }
        return true;
    }

//    public static <T> void printArray(T[][] array) {
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

}
