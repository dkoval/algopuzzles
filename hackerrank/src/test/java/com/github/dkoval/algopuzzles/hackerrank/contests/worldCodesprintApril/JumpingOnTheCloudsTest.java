package com.github.dkoval.algopuzzles.hackerrank.contests.worldCodesprintApril;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link JumpingOnTheClouds} solution.
 */
@RunWith(Parameterized.class)
public class JumpingOnTheCloudsTest {
    private final int[] c;
    private final int answer;

    public JumpingOnTheCloudsTest(int[] c, int answer) {
        this.c = c;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 0, 1, 0, 0, 1, 0}, 4},
                {new int[]{0, 0, 0, 1, 0, 0}, 3},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = JumpingOnTheClouds.solve(c);
        assertEquals(answer, myAnswer);
    }
}
