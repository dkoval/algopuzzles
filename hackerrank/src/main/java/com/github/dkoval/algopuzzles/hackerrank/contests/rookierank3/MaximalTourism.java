package com.github.dkoval.algopuzzles.hackerrank.contests.rookierank3;

import java.util.*;

/**
 * <a href="https://www.hackerrank.com/contests/rookierank-3/challenges/maximal-tourism>Maximal Tourism</a>
 * Max Score: 25 Difficulty: Medium
 */
public class MaximalTourism {

    public static class Graph {
        private final List<Integer> adj[];

        public Graph(int n, int[][] routes) {
            adj = (List<Integer>[]) new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new LinkedList<>();
            }
            for (int[] fromTo : routes) {
                addEdge(fromTo[0], fromTo[1]);
            }
        }

        public int getNumVertices() {
            return adj.length;
        }

        public Iterable<Integer> getAdjVertices(int v) {
            return adj[v];
        }

        public void addEdge(int u, int w) {
            adj[u].add(w);
            adj[w].add(u);
        }
    }

    static int solve(int n, int[][] routes) {
        Graph g = new Graph(n + 1, routes);
        Map<Integer, Integer> sizes = findConnectedComponents(g);
        // select connected component with maximum number of vertices
        return Collections.max(sizes.values());
    }

    private static Map<Integer, Integer> findConnectedComponents(Graph g) {
        // number of connected components
        int count = 0;
        // sizes.get(id) is a number of vertices in given connected component
        Map<Integer, Integer> sizes = new HashMap<>();

        Set<Integer> visited = new HashSet<>();
        for (int v = 1; v < g.getNumVertices(); v++) {
            if (!visited.contains(v)) {
                dfs(g, v, visited, sizes, count);
                count++;
            }
        }
        return sizes;
    }

    private static void dfs(Graph g, int v, Set<Integer> visited, Map<Integer, Integer> sizes, int id) {
        visited.add(v);

        Integer prevSize = sizes.get(id);
        if (prevSize == null) {
            prevSize = 0;
        }
        sizes.put(id, prevSize + 1);

        for (int w : g.getAdjVertices(v)) {
            if (!visited.contains(w)) {
                dfs(g, w, visited, sizes, id);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] route = new int[m][2];
        for (int route_i = 0; route_i < m; route_i++) {
            for (int route_j = 0; route_j < 2; route_j++) {
                route[route_i][route_j] = in.nextInt();
            }
        }
        int ans = solve(n, route);
        System.out.println(ans);
    }
}
