package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Pangrams} solution.
 */
@RunWith(Parameterized.class)
public class PangramsTest {
    private final String input;
    private final boolean answer;

    public PangramsTest(String input, boolean answer) {
        this.input = input;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"We promptly judged antique ivory buckles for the next prize", true},
                {"We promptly judged antique ivory buckles for the prize", false},
        });
    }

    @Test
    public void isPangram() throws Exception {
        boolean myAnswer = Pangrams.isPangram(input);
        assertEquals(answer, myAnswer);
    }
}
