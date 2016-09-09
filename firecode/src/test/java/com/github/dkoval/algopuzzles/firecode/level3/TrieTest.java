package com.github.dkoval.algopuzzles.firecode.level3;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests {@link Trie} solution.
 */
public class TrieTest {
    private static Trie trie;

    @BeforeClass
    public static void setup() {
        trie = new Trie();
        trie.insertWord("AB");
        trie.insertWord("ABS");
        trie.insertWord("ADS");
        trie.insertWord("ADSD");
        trie.insertWord("ACS");
    }

    @Test
    public void searchWord() {
        Boolean actual = trie.searchWord("AC");
        assertFalse(actual);
    }

    @Test
    public void searchNullWord() {
        Boolean actual = trie.searchWord(null);
        assertFalse(actual);
    }

    @Test
    public void searchEmptyWord() {
        Boolean actual = trie.searchWord("");
        assertFalse(actual);
    }

    @Test
    public void searchPrefix() {
        Boolean actual = trie.searchPrefix("AC");
        assertTrue(actual);
    }

    @Test
    public void searchNullPrefix() {
        Boolean actual = trie.searchPrefix(null);
        assertFalse(actual);
    }

    @Test
    public void searchEmptyPrefix() {
        Boolean actual = trie.searchPrefix("");
        assertFalse(actual);
    }
}
