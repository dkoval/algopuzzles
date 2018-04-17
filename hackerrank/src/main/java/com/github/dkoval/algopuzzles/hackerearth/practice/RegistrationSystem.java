package com.github.dkoval.algopuzzles.hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RegistrationSystem {

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean occupied;
        int suffix;
    }

    private TrieNode root = new TrieNode();

    String register(String login) {
        TrieNode node = insert(root, login);
        if (node == null) {
            return login;
        } else {
            return login + generateSuffix(node);
        }
    }

    private TrieNode insert(TrieNode node, String login) {
        TrieNode current = node;
        for (int i = 0; i < login.length(); i++) {
            char ch = login.charAt(i);
            current = current.children.computeIfAbsent(ch, key -> new TrieNode());
        }
        if (current.occupied) {
            return current;
        }
        current.occupied = true;
        return null;
    }

    private long generateSuffix(TrieNode node) {
        TrieNode current;
        do {
            current = insert(node, Integer.toString(node.suffix));
            if (current != null) {
                node.suffix++;
            }
        } while (current != null);
        return node.suffix;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            RegistrationSystem db = new RegistrationSystem();
            while (n-- > 0) {
                String login = in.readLine();
                login = db.register(login);
                System.out.println(login);
            }
        }
    }
}
