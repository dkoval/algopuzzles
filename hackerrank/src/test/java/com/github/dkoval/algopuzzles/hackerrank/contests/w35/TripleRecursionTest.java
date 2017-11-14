package com.github.dkoval.algopuzzles.hackerrank.contests.w35;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * Tests {@link TripleRecursion} solution.
 */
@RunWith(Parameterized.class)
public class TripleRecursionTest {
    private final int n;
    private final int m;
    private final int k;
    private final int[][] answer;

    public TripleRecursionTest(int n, int m, int k, int[][] answer) {
        this.n = n;
        this.m = m;
        this.k = k;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, 3, 1, new int[][]{
                        {3, 2, 1, 0},
                        {2, 4, 3, 2},
                        {1, 3, 5, 4},
                        {0, 2, 4, 6}
                }},
                {5, 10, 7, new int[][]{
                        {10, 9, 8, 7, 6},
                        {9, 17, 16, 15, 14},
                        {8, 16, 24, 23, 22},
                        {7, 15, 23, 31, 30},
                        {6, 14, 22, 30, 38},
                }},
        });
    }

    @Test
    public void solution() throws Exception {
        int[][] myAnswer = TripleRecursion.tripleRecursion(n, m, k);
        for (int i = 0; i < myAnswer.length; i++) {
            assertArrayEquals(answer[i], myAnswer[i]);
        }
    }
}
