package com.github.dkoval.algopuzzles.codefights;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FindSubstringsTest {
    private final String[] words;
    private final String[] parts;
    private final String[] expected;

    public FindSubstringsTest(String[] words, String[] parts, String[] expected) {
        this.words = words;
        this.parts = parts;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new String[]{"Apple", "Melon", "Orange", "Watermelon"},
                        new String[]{"a", "mel", "lon", "el", "An"},
                        new String[]{"Apple", "Me[lon]", "Or[a]nge", "Water[mel]on"}
                },
                {
                        new String[]{"Aaaaaaaaa", "bcdEFGh"},
                        new String[]{"aaaaa", "Aaaa", "E", "z", "Zzzzz"},
                        new String[]{"A[aaaaa]aaa", "bcd[E]FGh"},
                },
                {
                        new String[]{},
                        new String[]{"aaaaa", "Aaaa", "E", "z", "Zzzzz", "a", "mel", "lon", "el", "An"},
                        new String[]{}
                }
        });
    }

    @Test
    public void findSubstrings() {
        String[] actual = FindSubstrings.findSubstrings(words, parts);
        assertArrayEquals(expected, actual);
    }
}
