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
    private final String expctedAnswer;

    public ReverseShuffleMergeTest(String input, String expctedAnswer) {
        this.input = input;
        this.expctedAnswer = expctedAnswer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"eggegg", "egg"},
                {"acatsastac", "aastc"},
        });
    }

    @Test
    public void solve() throws Exception {
        String actualAnswer = ReverseShuffleMerge.solve(input);
        assertEquals(expctedAnswer, actualAnswer);
    }
}
