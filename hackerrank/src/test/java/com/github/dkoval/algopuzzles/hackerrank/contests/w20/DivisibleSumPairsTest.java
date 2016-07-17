package com.github.dkoval.algopuzzles.hackerrank.contests.w20;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link DivisibleSumPairs} solution.
 */
@RunWith(Parameterized.class)
public class DivisibleSumPairsTest {
    private final int[] a;
    private final int k;
    private final int answer;

    public DivisibleSumPairsTest(int[] a, int k, int answer) {
        this.a = a;
        this.k = k;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 3, 2, 6, 1, 2}, 3, 5},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = DivisibleSumPairs.solve(a, k);
        assertEquals(answer, myAnswer);
    }
}
