package com.github.dkoval.algopuzzles.hackerearth.tutorial;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TrieTest {

    @Test
    public void searchEngine() {
        Trie.SearchEngine se = new Trie.SearchEngine();
        se.insert("hackerearth", 10);
        se.insert("hackerrank", 9);
        int weight = se.search("hacker");
        assertThat(weight, equalTo(10));
    }
}