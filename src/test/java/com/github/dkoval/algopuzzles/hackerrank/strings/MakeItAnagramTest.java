package com.github.dkoval.algopuzzles.hackerrank.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link MakeItAnagram} solution.
 */
@RunWith(Parameterized.class)
public class MakeItAnagramTest {
    private final String first;
    private final String second;
    private final int minNumOfCharDeletionsToMakeTwoStringsAnagrams;

    public MakeItAnagramTest(String first, String second, int minNumOfCharDeletionsToMakeTwoStringsAnagrams) {
        this.first = first;
        this.second = second;
        this.minNumOfCharDeletionsToMakeTwoStringsAnagrams = minNumOfCharDeletionsToMakeTwoStringsAnagrams;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"bacdc", "dcbac", 0},
                {"bacdc", "dcbad", 2},
                {"cde", "abc", 4},
                {"cdeff", "abcax", 8},
        });
    }

    @Test
    public void minNumOfCharDeletionsToMakeTwoStringsAnagrams() throws Exception {
        int answer = MakeItAnagram.minNumOfCharDeletionsToMakeTwoStringsAnagrams(first, second);
        assertEquals(minNumOfCharDeletionsToMakeTwoStringsAnagrams, answer);
    }
}