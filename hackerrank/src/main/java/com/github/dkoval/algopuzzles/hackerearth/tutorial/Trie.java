package com.github.dkoval.algopuzzles.hackerearth.tutorial;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerearth.com/practice/data-structures/advanced-data-structures/trie-keyword-tree/tutorial/">Trie (Keyword Tree)</a>
 */
public class Trie {

    static class SearchEngine {

        private static class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            boolean endOfWord = false;
            int weight = 0;
        }

        private TrieNode root = new TrieNode();

        void insert(String word, int weight) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.children.get(ch);
                if (node == null) {
                    node = new TrieNode();
                    current.children.put(ch, node);
                }
                node.weight = Math.max(node.weight, weight);
                current = node;
            }
            current.endOfWord = true;
        }

        int search(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.children.get(ch);
                if (node == null) {
                    return -1;
                }
                current = node;
            }
            return current.weight;
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int q = in.nextInt();
            SearchEngine se = new SearchEngine();
            while (n-- > 0) {
                String word = in.next();
                int weight = in.nextInt();
                se.insert(word, weight);
            }
            while (q-- > 0) {
                String term = in.next();
                int weight = se.search(term);
                System.out.println(weight);
            }
        }
    }
}
