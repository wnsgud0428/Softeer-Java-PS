package 코딩테스트_연습;

import java.util.ArrayList;
import java.util.List;

public class StringHandle {
    public static void main(String[] args) {
        String str = "apple";

        System.out.println(str.length());

        String str1 = str.substring(1, 2);
        String str2 = str.substring(2, 3);

        System.out.println(str1);

        /** 문자열 비교할때는 equals 사용! */
        if (str1.equals(str2)) { // 맞는 코드
            System.out.println("equals true");
        } else {
            System.out.println("equals false");
        }

        if (str1 == str2) { // 틀린 코드
            System.out.println("== true");
        } else {
            System.out.println("== false");
        }

        str = str.replace("p", "zz");
        System.out.println(str);


        int int1 = Integer.parseInt("0100");
        System.out.println(int1);

        StringBuilder sb = new StringBuilder("apple");

        sb.insert(2, "zz");
        System.out.println(sb);
        sb.delete(2, 3);
        System.out.println(sb);
        sb.deleteCharAt(2);
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);


    }
}
