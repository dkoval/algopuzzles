package com.github.dkoval.algopuzzles.ctci.ch04;

import com.github.dkoval.algopuzzles.ctci.lib.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Q4.1 Route Between Nodes: Give a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 */
public class Q401RouteBetweenNodes {

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
            for (Graph.Edge e : g.adj(u)) {
                int v = e.to();
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
