package swea;

import java.util.*;

public class SWEA1218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(sc.nextLine());
            String[] input = sc.nextLine().split("");

//            left가 들어오면 -> push;
//            right가 들어오면 -> pop해서 매치 되는지 확인;
            int answer = -1;
            if (checkStack(input)) answer = 1;
            else answer = 0;

            System.out.println("#"+test_case+" "+answer);

        }
    }

    public static boolean checkStack(String[] input_data) {
        Set<String> left = new HashSet<>(Arrays.asList("(", "[", "{", "<"));
        Set<String> right = new HashSet<>(Arrays.asList(")", "]", "}", ">"));

        Stack<String> stack = new Stack<>();
        for (String e : input_data) {
            if (left.contains(e)) {
                stack.push(e);
            } else if (right.contains(e)) {
                try {
                    String poped = stack.pop();
                    if (!isMatch(poped, e)) return false;
                } catch (Exception exception) {
                    return false;
                }
            }
        }

        if (stack.size() > 0) return false;

        return true;
    }

    public static boolean isMatch(String l, String r) {
        if (l.equals("(") && r.equals(")")) return true;
        else if (l.equals("[") && r.equals("]")) return true;
        else if (l.equals("{") && r.equals("}")) return true;
        else if (l.equals("<") && r.equals(">")) return true;
        return false;
    }
}
