package com.github.dkoval.algopuzzles.hackerrank.challenges.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * Tests {@link ClosestNumbers} solution.
 */
@RunWith(Parameterized.class)
public class ClosestNumbersTest {
    private final int[] a;
    private final int[] answer;

    public ClosestNumbersTest(int[] a, int[] answer) {
        this.a = a;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854}, new int[]{-20, 30}},
                {new int[]{-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470}, new int[]{-520, -470, -20, 30}},
                {new int[]{5, 4, 3, 2}, new int[]{2, 3, 3, 4, 4, 5}},
        });
    }

    @Test
    public void solution() throws Exception {
        int[] myAnswer = ClosestNumbers.solve(a);
        assertArrayEquals(answer, myAnswer);
    }
}