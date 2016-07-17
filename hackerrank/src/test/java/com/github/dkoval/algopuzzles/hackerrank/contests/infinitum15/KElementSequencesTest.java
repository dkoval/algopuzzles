package com.github.dkoval.algopuzzles.hackerrank.contests.infinitum15;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests {@link KElementSequences} solution.
 */
@RunWith(Parameterized.class)
public class KElementSequencesTest {
    private final int n;
    private final int k;
    private final long expectedAnswer;

    public KElementSequencesTest(int n, int k, int expectedAnswer) {
        this.n = n;
        this.k = k;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, 3, 3},
                {5, 2, 4},
                {7, 7, 1},
        });
    }

    @Test
    public void solve() throws Exception {
        long actualAnswer = KElementSequences.solve(n, k);
        assertEquals(expectedAnswer, actualAnswer);
    }
}