package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link BearAndSteadyGene} solution.
 */
@RunWith(Parameterized.class)
public class BearAndSteadyGeneTest {
    private final String input;
    private final int expectedAnswer;

    public BearAndSteadyGeneTest(String input, int expectedAnswer) {
        this.input = input;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws Exception {
        return Arrays.asList(new Object[][]{
                {"GAAATAAA", 5},
                {"GGAAATTC", 1},
                {"GGAATTCC", 0},
                // Downloaded Test Case #4
                {new String(Files.readAllBytes(
                        Paths.get(BearAndSteadyGeneTest.class
                                .getResource("/com/github/dkoval/algopuzzles/hackerrank/strings/BearAndSteadyGene-TestCase4.txt")
                                .toURI())),
                        StandardCharsets.UTF_8), 206},
        });
    }

    @Test
    public void minLengthOfSubstringReplacedToMakeGeneStable() throws Exception {
        int answer = BearAndSteadyGene.minLengthOfSubstringReplacedToMakeGeneStable(input);
        assertEquals(expectedAnswer, answer);
    }
}
