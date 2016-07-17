package com.github.dkoval.algopuzzles.ctci.ch04TreesAndGraphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Q4.1 Route Between Nodes: Give a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 */
public class Q01RouteBetweenNodes {

    public static class Graph {
        private final List<Edge> adj[];

        public Graph(int n) {
            adj = (List<Edge>[]) new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void add(Edge e) {
            int v = e.from;
            adj[v].add(e);
        }

        public Iterable<Edge> adj(int v) {
            return adj[v];
        }

        public int numOfVertices() {
            return adj.length;
        }
    }

    public static class Edge {
        private final int from;
        private final int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static boolean search(Graph g, int start, int end) {
        if (start == end) {
            return true;

        }
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[g.numOfVertices()];
        // BFS
        visited[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int u = q.remove();
            if (u == end) {
                // there is a path
                return true;
            }
            for (Edge e : g.adj(u)) {
                int v = e.to;
                if (!visited[v]) {
                    // only consider vertices that have not yet been visited
                    visited[v] = true;
                    q.add(v);
                }
            }
            visited[u] = true;
        }
        return false;
    }
}
