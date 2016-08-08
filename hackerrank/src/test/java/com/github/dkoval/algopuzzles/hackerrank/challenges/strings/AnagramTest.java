package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Anagram} solution.
 */
@RunWith(Parameterized.class)
public class AnagramTest {
    private final String input;
    private final int answer;

    public AnagramTest(String input, int answer) {
        this.input = input;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"aaabbb", 3},
                {"ab", 1},
                {"abc", -1},
                {"mnop", 2},
                {"xyyx", 0},
                {"xaxbbbxx", 1},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = Anagram.minNumOfChangesToMakeAnagram(input);
        assertEquals(answer, myAnswer);
    }
}
