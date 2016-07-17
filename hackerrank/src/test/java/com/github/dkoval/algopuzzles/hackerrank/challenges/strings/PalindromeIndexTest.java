package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link PalindromeIndex} solution.
 */
@RunWith(Parameterized.class)
public class PalindromeIndexTest {
    private final String input;
    private final int expectedPalindromeIndex;

    public PalindromeIndexTest(String input, int expectedPalindromeIndex) {
        this.input = input;
        this.expectedPalindromeIndex = expectedPalindromeIndex;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"aaab", 3},
                {"baa", 0},
                {"aaa", -1},
        });
    }

    @Test
    public void palindromeIndex() throws Exception {
        int actualPalindromeIndex = PalindromeIndex.palindromeIndex(input);
        assertEquals(expectedPalindromeIndex, actualPalindromeIndex);
    }
}