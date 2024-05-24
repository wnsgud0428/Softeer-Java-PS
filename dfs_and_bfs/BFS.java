package dfs_and_bfs;

import java.util.*;

public class BFS {
    public static boolean[] visited = new boolean[9];
    public static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

    // BFS 함수 정의
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (q.size() > 0) {
            int v = q.poll();
            System.out.print(v + " ");

            for (int i = 0; i < graph.get(v).size(); i++) {
                int next = graph.get(v).get(i);
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 노드 1에 연결된 노드 정보 저장
        graph.put(1, new ArrayList<Integer>());
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.put(2, new ArrayList<Integer>());
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.put(3, new ArrayList<Integer>());
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.put(4, new ArrayList<Integer>());
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.put(5, new ArrayList<Integer>());
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.put(6, new ArrayList<Integer>());
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.put(7, new ArrayList<Integer>());
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.put(8, new ArrayList<Integer>());
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
    }
}
