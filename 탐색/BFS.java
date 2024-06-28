package 탐색;

import java.util.*;

public class BFS {
    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList();

    // BFS 함수 정의
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList();
        visited[start] = true;
        System.out.print(start + " ");
        q.offer(start);

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int i = 0; i < graph.get(v).size(); i++) {
                int next = graph.get(v).get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    System.out.print(next + " ");
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 8; // (최대 8번 노드)
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
    }
}
