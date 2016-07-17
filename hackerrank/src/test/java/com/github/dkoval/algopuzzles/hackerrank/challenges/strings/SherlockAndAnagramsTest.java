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
    private final int expectedNumOfUnorderedAnagrammaticPairs;

    public SherlockAndAnagramsTest(String input, int expectedNumOfUnorderedAnagrammaticPairs) {
        this.input = input;
        this.expectedNumOfUnorderedAnagrammaticPairs = expectedNumOfUnorderedAnagrammaticPairs;
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
    public void numOfAnagrammaticPairs() throws Exception {
        int actualNumOfUnorderedAnagrammaticPairs = SherlockAndAnagrams.numOfUnorderedAnagrammaticPairs(input);
        assertEquals(expectedNumOfUnorderedAnagrammaticPairs, actualNumOfUnorderedAnagrammaticPairs);
    }
}
