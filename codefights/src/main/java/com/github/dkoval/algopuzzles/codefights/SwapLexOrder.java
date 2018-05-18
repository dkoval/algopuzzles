package com.github.dkoval.algopuzzles.codefights;

import java.util.*;

/**
 * <a href="https://codefights.com/interview-practice/task/5vXzdE9yzjsoMZ9sk">swapLexOrder</a>
 * Given a string str and array of pairs that indicates which indices in the string can be swapped,
 * return the lexicographically largest string that results from doing the allowed swaps.
 * You can swap indices any number of times.
 * <p>
 * Example
 * <p>
 * For str = "abdc" and pairs = [[1, 4], [3, 4]], the output should be swapLexOrder(str, pairs) = "dbca".
 */
public class SwapLexOrder {

    static class DisjointSet {
        private final int[] parents;

        DisjointSet(int size) {
            parents = new int[size];
            for (int p = 0; p < size; p++) {
                parents[p] = p;
            }
        }

        int find(int p) {
            while (p != parents[p]) {
                parents[p] = parents[parents[p]];
                p = parents[p];
            }
            return p;
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            parents[rootQ] = rootP;
        }
    }

    static String swapLexOrder(String str, int[][] pairs) {
        int n = str.length();
        DisjointSet set = getConnectedGroups(n, pairs);
        Map<Integer, Queue<Character>> groups = mapCharsToGroups(str, set, Comparator.reverseOrder());
        return mkString(n, set, groups);
    }

    private static Map<Integer, Queue<Character>> mapCharsToGroups(String str, DisjointSet set, Comparator<Character> comparator) {
        Map<Integer, Queue<Character>> groups = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int group = set.find(i);
            groups.computeIfAbsent(group, key -> new PriorityQueue<>(comparator)).offer(ch);
        }
        return groups;
    }

    private static DisjointSet getConnectedGroups(int n, int[][] pairs) {
        DisjointSet set = new DisjointSet(n);
        for (int[] pair : pairs) {
            // string in question is said to be 1-indexed
            set.union(--pair[0], --pair[1]);
        }
        return set;
    }

    private static String mkString(int n, DisjointSet set, Map<Integer, Queue<Character>> groups) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int group = set.find(i);
            Queue<Character> chars = groups.get(group);
            sb.append(chars.poll());
        }
        return sb.toString();
    }
}
