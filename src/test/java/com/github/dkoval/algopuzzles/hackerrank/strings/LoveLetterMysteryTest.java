package com.github.dkoval.algopuzzles.hackerrank.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link LoveLetterMystery} solution.
 */
@RunWith(Parameterized.class)
public class LoveLetterMysteryTest {
    private final String input;
    private final int expectedMinNumOfOpsToFormPalindrome;

    public LoveLetterMysteryTest(String input, int expectedMinNumOfOpsToFormPalindrome) {
        this.input = input;
        this.expectedMinNumOfOpsToFormPalindrome = expectedMinNumOfOpsToFormPalindrome;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abc", 2},
                {"abcba", 0},
                {"abcd", 4},
                {"cba", 2},
        });
    }

    @Test
    public void minNumOfOpsToFormPalindrome() throws Exception {
        int actualMinNumOfOpsToFormPalindrome = LoveLetterMystery.minNumOfOpsToFormPalindrome(input);
        assertEquals(expectedMinNumOfOpsToFormPalindrome, actualMinNumOfOpsToFormPalindrome);
    }
}