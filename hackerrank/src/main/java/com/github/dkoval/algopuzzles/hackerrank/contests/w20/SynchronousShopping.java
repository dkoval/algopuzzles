package com.github.dkoval.algopuzzles.hackerrank.contests.w20;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/w20/challenges/synchronous-shopping">Problem:</a>
 * Max Score: 23.62 Difficulty: Moderate
 */
public class SynchronousShopping {

    public static class Edge {
        private final int from;
        private final int to;
        private final int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static class Graph {
        private final List<Edge>[] adj;

        public Graph(int n) {
            //noinspection unchecked
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

    static class VertexMetaInfo {
        final int v;
        final int mask;
        final int time;

        public VertexMetaInfo(int v, int mask, int time) {
            this.v = v;
            this.mask = mask;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int answer = solve(in);
        System.out.println(answer);
    }

    static int solve(Scanner in) {
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();

        // mask[i] refers to types of fish being sold at i-th shopping center
        int[] mask = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int t = in.nextInt();
            for (int j = 0; j < t; j++) {
                int typeOfFish = in.nextInt();
                mask[i] |= 1 << (typeOfFish - 1);
            }
        }

        // models N shopping centers connected by M roads
        Graph g = new Graph(n + 1);
        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), w = in.nextInt();
            g.add(new Edge(x, y, w));
            g.add(new Edge(y, x, w));
        }

        int[][] times = calcMinTimes(g, mask, k);
        return minSyncShoppingTime(times, n, k);
    }

    private static int[][] calcMinTimes(Graph g, int[] mask, int k) {
        int n = g.numOfVertices();
        int[][] time = initTimes(n, k);
        time[1][mask[1]] = 0;

        Queue<VertexMetaInfo> q = new LinkedList<>();
        q.add(new VertexMetaInfo(1, mask[1], 0));
        while (!q.isEmpty()) {
            VertexMetaInfo cur = q.remove();
            for (Edge e : g.adj(cur.v)) {
                int to = e.to;
                int toMask = cur.mask | mask[to];
                int oldToTime = time[to][toMask];
                int newToTime = cur.time + e.weight;
                if (oldToTime > newToTime) {
                    time[to][toMask] = newToTime;
                    q.add(new VertexMetaInfo(to, toMask, newToTime));
                }
            }
        }
        return time;
    }

    private static int[][] initTimes(int n, int k) {
        int maxMask = 1 << k;
        int[][] times = new int[n + 1][maxMask];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < maxMask; j++) {
                times[i][j] = Integer.MAX_VALUE;
            }
        }
        return times;
    }

    private static int minSyncShoppingTime(int times[][], int n, int k) {
        int maxMask = 1 << k;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < maxMask; i++) {
            for (int j = 0; j < maxMask; j++) {
                if ((i | j) == maxMask - 1) {
                    answer = Math.min(answer, Math.max(times[n][i], times[n][j]));
                }
            }
        }
        return answer;
    }
}
