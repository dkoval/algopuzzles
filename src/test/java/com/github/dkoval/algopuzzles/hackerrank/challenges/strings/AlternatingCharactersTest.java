package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link AlternatingCharacters} solution.
 */
@RunWith(Parameterized.class)
public class AlternatingCharactersTest {
    private final String input;
    private final int expectedMinNumOfDeletions;

    public AlternatingCharactersTest(String input, int expectedMinNumOfDeletions) {
        this.input = input;
        this.expectedMinNumOfDeletions = expectedMinNumOfDeletions;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"AAAA", 3},
                {"BBBBB", 4},
                {"ABABABAB", 0},
                {"BABABA", 0},
                {"AAABBB", 4},
        });
    }

    @Test
    public void minNumOfDeletions() throws Exception {
        int actualMinNumOfDeletions = AlternatingCharacters.minNumOfDeletions(input);
        assertEquals(expectedMinNumOfDeletions, actualMinNumOfDeletions);
    }
}