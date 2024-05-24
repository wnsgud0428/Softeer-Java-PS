package dfs_and_bfs; /** 2차원 배열에서의 BFS **/
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

class BFS_IN_2DArray {
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

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

        ArrayList<Integer> counts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    int value = bfs(new Node(i, j), board, N, visited);
                    if (value != -1) {
                        counts.add(value);
                    }
                }
            }
        }

        Collections.sort(counts);
        if (counts.size() > 0) {
            System.out.println(counts.size());
            for (int count : counts) {
                System.out.print(count + " ");
            }
            System.out.println();
        } else {
            System.out.println(0);
        }
    }

    public static int bfs(Node start, int[][] board, int N, boolean[][] visited) {
        if (!visited[start.r][start.c]) {
            Queue<Node> q = new LinkedList<>();
            q.offer(start);
            visited[start.r][start.c] = true;

            int count = 0;
            while (q.size() > 0) {
                Node v = q.poll();
                count += 1;
                for (int i = 0; i < 4; i++) {
                    int nr = v.r + dr[i];
                    int nc = v.c + dc[i];
                    if (0 <= nr && nr <= N - 1 && 0 <= nc && nc <= N - 1) {
                        if (board[nr][nc] == 1 && !visited[nr][nc]) {
                            q.offer(new Node(nr, nc));
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
            return count;
        }

        return -1;
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