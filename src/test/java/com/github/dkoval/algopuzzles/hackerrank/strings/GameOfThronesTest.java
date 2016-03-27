package com.github.dkoval.algopuzzles.hackerrank.strings;

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
    private final boolean anagramCanBePalindrome;

    public GameOfThronesTest(String input, boolean anagramCanBePalindrome) {
        this.input = input;
        this.anagramCanBePalindrome = anagramCanBePalindrome;
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
    public void anagramCanBePalindrome() throws Exception {
        boolean answer = GameOfThrones.anagramCanBePalindrome(input);
        assertEquals(anagramCanBePalindrome, answer);
    }
}