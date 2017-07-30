package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-contacts">Tries: Contacts</a>
 * Max Score: 50 Difficulty: Hard
 */
public class Contacts {

    static class Trie {
        private Node root = new Node();

        private class Node {
            final Map<Character, Node> letters = new HashMap<>();
            int wordCount = 0;
        }

        /**
         * Add the given word to the trie.
         *
         * @param word the word to add.
         */
        public void add(String word) {
            Node current = root;
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                Node node = current.letters.get(ch);
                if (node == null) {
                    node = new Node();
                    current.letters.put(ch, node);
                }
                current.wordCount++;
                current = node;
            }
        }

        /**
         * Returns the number of words containing the given prefix.
         *
         * @param prefix the prefix to check.
         * @return the number of words containing this prefix.
         */
        public int find(String prefix) {
            Node current = root;
            for (int i = 0; i < prefix.length(); i++) {
                Character ch = prefix.charAt(i);
                current = current.letters.get(ch);
                if (current == null) {
                    // prefix was not found
                    return 0;
                }
            }
            return current.wordCount;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie t = new Trie();
        for(int i = 0; i < n; i++){
            String op = in.next();
            String contact = in.next();
            if ("add".equals(op)) {
                t.add(contact);
            }
            if ("find".equals(op)) {
                int count = t.find(contact);
                System.out.println(count);
            }
        }
    }
}
