package com.github.dkoval.algopuzzles.hackerrank.contests.weekOfCode20;

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

    static class State {
        final int v;
        final int fishMask;
        final int time;

        public State(int v, int fishMask, int time) {
            this.v = v;
            this.fishMask = fishMask;
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
        int[] fishMask = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int t = in.nextInt();
            for (int j = 0; j < t; j++) {
                int typeOfFish = in.nextInt();
                fishMask[i] |= 1 << (typeOfFish - 1);
            }
        }

        Graph g = new Graph(n + 1);
        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), w = in.nextInt();
            g.add(new Edge(x, y, w));
            g.add(new Edge(y, x, w));
        }

        int[][] time = calcMinTimes(g, fishMask, k);
        return minSyncShoppingTime(time, n, k);
    }

    private static int[][] calcMinTimes(Graph g, int[] fishMask, int k) {
        int n = g.numOfVertices();
        int[][] time = initTime(n, k);
        time[1][fishMask[1]] = 0;

        Queue<State> q = new LinkedList<>();
        q.add(new State(1, fishMask[1], 0));
        while (!q.isEmpty()) {
            State cur = q.remove();
            for (Edge e : g.adj(cur.v)) {
                int to = e.to;
                int toFishMask = cur.fishMask | fishMask[to];

                int oldToTime = time[to][toFishMask];
                int newToTime = cur.time + e.weight;
                if (oldToTime > newToTime) {
                    // TODO: discard old state?
                    //q.remove(new State(to, toFishMask, oldToTime));
                    time[to][toFishMask] = newToTime;
                    q.add(new State(to, toFishMask, newToTime));
                }
            }
        }
        return time;
    }

    private static int[][] initTime(int n, int k) {
        int maxMask = 1 << k;
        int[][] time = new int[n + 1][maxMask];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < maxMask; j++) {
                time[i][j] = Integer.MAX_VALUE;
            }
        }
        return time;
    }

    private static int minSyncShoppingTime(int time[][], int n, int k) {
        int answer = Integer.MAX_VALUE;
        int maxMask = 1 << k;
        for (int i = 0; i < maxMask; i++) {
            for (int j = 0; j < maxMask; j++) {
                if ((i | j) == maxMask - 1) {
                    answer = Math.min(answer, Math.max(time[n][i], time[n][j]));
                }
            }
        }
        return answer;
    }
}
