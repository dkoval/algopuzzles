package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach">BFS: Shortest Reach in a Graph</a>
 * Max Score: 45 Difficulty: Hard
 */
public class ShortestReachInGraph {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            Graph g = new Graph(n);
            while (m-- > 0) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                g.addEdge(u, v);
            }
            int s = scan.nextInt() - 1;
            int[] distances = g.getShortestDistances(s);
            String answer = Arrays.stream(distances).boxed()
                    .filter(distance -> distance != 0)
                    .map(Object::toString)
                    .collect(Collectors.joining(" "));
            System.out.println(answer);
        }
    }

    public static class Graph {
        static final int EDGE_LENGTH = 6;

        private final List<Integer>[] adj;

        public Graph(int n) {
            adj = (List<Integer>[]) new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public Graph addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
            return this;
        }

        public int[] getShortestDistances(int s) {
            Queue<Integer> q = new LinkedList<>();
            int[] distances = new int[adj.length];
            Arrays.fill(distances, -1);

            q.add(s);
            distances[s] = 0;
            while (!q.isEmpty()) {
                int u = q.remove();
                for (int v : adj[u]) {
                    // only consider vertices that have not yet been visited
                    if (distances[v] == -1) {
                        q.add(v);
                        distances[v] = distances[u] + EDGE_LENGTH; // distances[v] stores the shortest distance from s to v
                    }
                }
            }
            return distances;
        }
    }
}
