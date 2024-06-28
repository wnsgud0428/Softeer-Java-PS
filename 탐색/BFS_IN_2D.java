package 탐색;

import java.io.*;
import java.util.*;

class Node {
    public int r;
    public int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class BFS_IN_2D {
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static void bfs(Node start, int[][] board, int N, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        visited[start.r][start.c] = true;
        System.out.printf("(%d, %d) ", start.r, start.c);
        q.offer(start);

        while (!q.isEmpty()) {
            Node v = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = v.r + dr[i];
                int nc = v.c + dc[i];
                if (0 <= nr && nr <= N - 1 && 0 <= nc && nc <= N - 1) {
                    if (board[nr][nc] == 1 && !visited[nr][nc]) {
                        System.out.printf("(%d, %d) ", nr, nc);
                        visited[nr][nc] = true;
                        q.offer(new Node(nr, nc));
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
//        printArray(board);

        boolean[][] visited = new boolean[N][N];
        // boolean 초기값은 false -> 초기화 필요x

        bfs(new Node(0, 0), board, N, visited);
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