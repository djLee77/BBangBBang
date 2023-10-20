package Algorithm.seach;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void dfs(int node) {
        visited[node] = true;
        System.out.println(node);

        for (int nextNode : graph[node]) {
            if (!visited[nextNode]) {
                dfs(nextNode);
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

        dfs(0);
    }
}

