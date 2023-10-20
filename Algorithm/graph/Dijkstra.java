package Algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    static class Edge {
        int node, weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static List<Edge>[] graph;
    static int[] distances;
    static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        distances[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (distances[current.node] < current.weight) continue;

            for (Edge edge : graph[current.node]) {
                int newDist = current.weight + edge.weight;
                if (newDist < distances[edge.node]) {
                    distances[edge.node] = newDist;
                    pq.add(new Edge(edge.node, newDist));
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
        distances = new int[numNodes];
        Arrays.fill(distances, INF);

        graph[0].add(new Edge(1, 2));
        graph[0].add(new Edge(2, 3));
        graph[1].add(new Edge(3, 2));
        graph[2].add(new Edge(3, 1));
        graph[2].add(new Edge(4, 5));
        graph[3].add(new Edge(4, 1));

        dijkstra(0);
        for (int i = 0; i < numNodes; i++) {
            System.out.println("Shortest distance from 0 to " + i + " is " + distances[i]);
        }
    }
}

