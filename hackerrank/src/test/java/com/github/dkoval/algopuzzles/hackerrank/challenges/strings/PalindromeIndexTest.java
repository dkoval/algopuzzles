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
    private final int answer;

    public PalindromeIndexTest(String input, int answer) {
        this.input = input;
        this.answer = answer;
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
    public void solution() throws Exception {
        int myAnswer = PalindromeIndex.palindromeIndex(input);
        assertEquals(answer, myAnswer);
    }
}
