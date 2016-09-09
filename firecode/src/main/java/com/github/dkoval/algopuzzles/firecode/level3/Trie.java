package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TrieNode;

import java.util.HashMap;

/**
 * You're given a completed TrieNode class that represents one node of a Trie, and a partially complete Trie class.
 * Your task is to complete the insertWord, searchWord and searchPrefix methods on the Trie class.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insertWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            t = children.get(c);
            if (t == null) {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
        }
        if (t != null) {
            t.isLeaf = true;
        }
    }

    public Boolean searchWord(String word) {
        TrieNode t = doSearch(word);
        return (t != null) && t.isLeaf;
    }

    public Boolean searchPrefix(String word) {
        return doSearch(word) != null;
    }

    private TrieNode doSearch(String word) {
        if (word == null || word.isEmpty()) {
            return null;
        }
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            t = children.get(c);
            if (t != null) {
                children = t.children;
            } else {
                return null;
            }
        }
        return t;
    }
}
