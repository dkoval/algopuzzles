package com.github.dkoval.algopuzzles.firecode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Palindrome} solution.
 */
@RunWith(Parameterized.class)
public class PalindromeTest {
    private final int x;
    private final boolean answer;

    public PalindromeTest(int x, boolean answer) {
        this.x = x;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {-1, false},
                {12321, true},
                {0, true},
                {1221, true},
                {123, false},
        });
    }

    @Test
    public void isIntPalindrome() throws Exception {
        boolean myAnswer = Palindrome.isIntPalindrome(x);
        assertEquals(answer, myAnswer);
    }
}