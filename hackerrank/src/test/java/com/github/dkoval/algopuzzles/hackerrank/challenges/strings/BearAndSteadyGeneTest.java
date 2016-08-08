package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link BearAndSteadyGene} solution.
 */
@RunWith(Parameterized.class)
public class BearAndSteadyGeneTest {
    private final String input;
    private final int answer;

    public BearAndSteadyGeneTest(String input, int answer) {
        this.input = input;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws Exception {
        return Arrays.asList(new Object[][]{
                {"GAAATAAA", 5},
                {"GGAAATTC", 1},
                {"GGAATTCC", 0},
                // Downloaded Test Case #4
                /*{new String(Files.readAllBytes(
                        Paths.get(BearAndSteadyGeneTest.class
                                .getResource("com/github/dkoval/algopuzzles/hackerrank/challenges/strings/BearAndSteadyGene-TestCase4.txt")
                                .toURI())),
                        StandardCharsets.UTF_8), 206},*/
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = BearAndSteadyGene.minLengthOfSubstringReplacedToMakeGeneStable(input);
        assertEquals(answer, myAnswer);
    }
}
