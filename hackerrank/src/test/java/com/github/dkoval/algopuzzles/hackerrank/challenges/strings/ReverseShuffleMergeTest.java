package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link ReverseShuffleMerge} solution.
 */
@RunWith(Parameterized.class)
public class ReverseShuffleMergeTest {
    private final String input;
    private final String answer;

    public ReverseShuffleMergeTest(String input, String answer) {
        this.input = input;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"eggegg", "egg"},
                {"acatsastac", "aastc"},
        });
    }

    @Test
    public void solution() throws Exception {
        String myAnswer = ReverseShuffleMerge.solve(input);
        assertEquals(answer, myAnswer);
    }
}
