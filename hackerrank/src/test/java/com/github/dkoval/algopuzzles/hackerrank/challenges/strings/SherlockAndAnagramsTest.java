package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link SherlockAndAnagrams} solution.
 */
@RunWith(Parameterized.class)
public class SherlockAndAnagramsTest {
    private final String input;
    private final int answer;

    public SherlockAndAnagramsTest(String input, int answer) {
        this.input = input;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws Exception {
        return Arrays.asList(new Object[][]{
                {"abba", 4},
                {"abcd", 0},
                {"ifailuhkqq", 3},
                {"hucpoltgty", 2},
                {"ovarjsnrbf", 2},
                {"pvmupwjjjf", 6},
                {"iwwhrlkpek", 3},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = SherlockAndAnagrams.numOfUnorderedAnagrammaticPairs(input);
        assertEquals(answer, myAnswer);
    }
}
