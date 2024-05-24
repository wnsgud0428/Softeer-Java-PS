import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Problem5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        boolean[][] visited = new boolean[n][m];

        int[][] board = new int[n][m];
//        int start_r = 2;
//        int start_c = 2;
//        for (int i = 0; i < 8; i++) {
//            int nr = start_r + dr[i];
//            int nc = start_c + dc[i];
//            board[nr][nc] = 1;
//        }
//        printArray(board);
        String answer = bfs(new Node(0,0,0), board, n, m, visited);
        System.out.println(answer);

    }

    // 전체다 탐색가능한지 true / false
    // 탐색가능하면 얼마나 가야하는지
    public static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};


    public static String bfs(Node start, int[][] board, int n, int m, boolean[][] visitied) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        visitied[start.r][start.c] = true;
        Stack<Node> save = new Stack<>();
        while (q.size() > 0) {
            Node v = q.poll();
            save.push(v);

            for (int i = 0; i < 8; i++) {
                int nr = v.r + dr[i];
                int nc = v.c + dc[i];
                if (0 <= nr && nr <= n - 1 && 0 <= nc && nc <= m - 1)
                    if (!visitied[nr][nc]) {
                        board[nr][nc] = v.distance + 1;
                        q.offer(new Node(nr, nc, v.distance + 1));
                        visitied[nr][nc] = true;
                    }
            }
        }
        String answer_string = "";

        // 전부 visited인지 체크하기
        if (isAllVisited(visitied)) answer_string += "T";
        else answer_string += "F";
        answer_string += save.peek().distance + "";

        return answer_string;
    }

    public static boolean isAllVisited(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j]) return false;
            }
        }

        return true;
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Node {
    public int r;
    public int c;
    public int distance;

    public Node(int r, int c, int distance) {
        this.r = r;
        this.c = c;
        this.distance = distance;
    }
}