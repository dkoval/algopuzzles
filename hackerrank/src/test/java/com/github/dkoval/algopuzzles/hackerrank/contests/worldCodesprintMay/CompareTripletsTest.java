package com.github.dkoval.algopuzzles.hackerrank.contests.worldCodesprintMay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * Tests {@link CompareTriplets} solution.
 */
@RunWith(Parameterized.class)
public class CompareTripletsTest {
    private final int[] a;
    private final int[] b;
    private final int[] answer;

    public CompareTripletsTest(int[] a, int[] b, int[] answer) {
        this.a = a;
        this.b = b;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5, 6, 7}, new int[]{3, 6, 10}, new int[]{1, 1}},
        });
    }

    @Test
    public void solution() throws Exception {
        int[] myAnswer = CompareTriplets.solve(a, b);
        assertArrayEquals(answer, myAnswer);
    }
}