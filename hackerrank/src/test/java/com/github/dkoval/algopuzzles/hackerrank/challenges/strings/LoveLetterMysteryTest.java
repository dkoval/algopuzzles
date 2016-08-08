package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

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
    private final int answer;

    public LoveLetterMysteryTest(String input, int answer) {
        this.input = input;
        this.answer = answer;
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
    public void solution() throws Exception {
        int myAnswer = LoveLetterMystery.minNumOfOpsToFormPalindrome(input);
        assertEquals(answer, myAnswer);
    }
}
