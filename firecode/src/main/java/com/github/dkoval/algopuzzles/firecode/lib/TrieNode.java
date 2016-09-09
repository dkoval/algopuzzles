package com.github.dkoval.algopuzzles.firecode.lib;

import java.util.HashMap;

public class TrieNode {
    public Character c;
    public Boolean isLeaf = false;
    public HashMap<Character, TrieNode> children = new HashMap<>();

    public TrieNode() {}

    public TrieNode(Character c) {
        this.c = c;
    }
}
