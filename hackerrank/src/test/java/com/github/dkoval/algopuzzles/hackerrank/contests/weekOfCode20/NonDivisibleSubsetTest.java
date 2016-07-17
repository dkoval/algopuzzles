package com.github.dkoval.algopuzzles.hackerrank.contests.weekOfCode20;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link NonDivisibleSubset} solution.
 */
@RunWith(Parameterized.class)
public class NonDivisibleSubsetTest {
    private final int[] s;
    private final int k;
    private final int answer;

    public NonDivisibleSubsetTest(int[] s, int k, int answer) {
        this.s = s;
        this.k = k;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 7, 2, 4}, 3, 3},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = NonDivisibleSubset.solve(s, k);
        assertEquals(answer, myAnswer);
    }
}
