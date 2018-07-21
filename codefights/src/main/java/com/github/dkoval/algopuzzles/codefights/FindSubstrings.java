package com.github.dkoval.algopuzzles.codefights;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://app.codesignal.com/interview-practice/task/Ki9zRh5bfRhH6oBau">findSubstrings</a>
 * You have two arrays of strings, words and parts. Return an array that contains the strings from words, modified
 * so that any occurrences of the substrings from parts are surrounded by square brackets [], following these guidelines:
 * <p>
 * If several parts substrings occur in one string in words, choose the longest one. If there is still more than one such part,
 * then choose the one that appears first in the string.
 */
public class FindSubstrings {

    static class Trie {
        private final Node root = new Node();

        private class Node {
            final Map<Character, Node> children = new HashMap<>();
            boolean terminal;
        }

        void add(String word) {
            Node current = root;
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                current = current.children.computeIfAbsent(ch, key -> new Node());
            }
            current.terminal = true;
        }

        String findSubstring(String word) {
            int longestSubstringLength = 0, longestSubstringStartPos = 0;
            for (int i = 0; i < word.length(); i++) {
                Node current = root;
                for (int j = i; j < word.length(); j++) {
                    Character ch = word.charAt(j);
                    current = current.children.get(ch);
                    if (current == null) {
                        break;
                    }
                    int length = j - i + 1;
                    if (current.terminal && length > longestSubstringLength) {
                        longestSubstringLength = length;
                        longestSubstringStartPos = i;
                    }
                }
            }
            if (longestSubstringLength == 0) {
                return word;
            }
            int longestSubstringEndPos = longestSubstringStartPos + longestSubstringLength;
            return word.substring(0, longestSubstringStartPos)
                    + '[' + word.substring(longestSubstringStartPos, longestSubstringEndPos) + ']'
                    + word.substring(longestSubstringEndPos);
        }
    }

    static String[] findSubstrings(String[] words, String[] parts) {
        Trie trie = buildTrie(parts);
        return Arrays.stream(words)
                .map(trie::findSubstring)
                .toArray(String[]::new);
    }

    private static Trie buildTrie(String[] parts) {
        Trie trie = new Trie();
        for (String part : parts) {
            trie.add(part);
        }
        return trie;
    }
}
