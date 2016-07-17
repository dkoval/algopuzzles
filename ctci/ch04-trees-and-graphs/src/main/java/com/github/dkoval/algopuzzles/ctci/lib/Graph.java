package com.github.dkoval.algopuzzles.ctci.lib;

import java.util.LinkedList;
import java.util.List;

/**
 * Adjacency list representation of an unweighted graph.
 */
public class Graph {
    private final List<Edge> adj[];

    public Graph(int n) {
        adj = (List<Edge>[]) new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void add(Edge e) {
        int v = e.from();
        adj[v].add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public int numOfVertices() {
        return adj.length;
    }

    public static class Edge {
        private final int from;
        private final int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int from() {
            return from;
        }

        public int to() {
            return to;
        }
    }
}
