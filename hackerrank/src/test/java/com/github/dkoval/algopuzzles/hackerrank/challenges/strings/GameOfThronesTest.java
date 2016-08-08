package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link GameOfThrones} solution.
 */
@RunWith(Parameterized.class)
public class GameOfThronesTest {
    private final String input;
    private final boolean answer;

    public GameOfThronesTest(String input, boolean answer) {
        this.input = input;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"aaabbbb", true},
                {"cdefghmnopqrstuvw", false},
                {"cdcdcdcdeeeef", true},
        });
    }

    @Test
    public void solution() throws Exception {
        boolean myAnswer = GameOfThrones.anagramCanBePalindrome(input);
        assertEquals(answer, myAnswer);
    }
}
