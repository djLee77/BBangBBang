package Algorithm.seach;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);

            for (int nextNode : graph[node]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        int numNodes = 5;
        graph = new ArrayList[numNodes];
        for (int i = 0; i < numNodes; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[numNodes];

        graph[0].add(1);
        graph[0].add(2);
        graph[1].add(3);
        graph[2].add(4);

        bfs(0);
    }
}
