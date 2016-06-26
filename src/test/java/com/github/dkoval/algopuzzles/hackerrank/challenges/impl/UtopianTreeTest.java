package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link UtopianTree} solution.
 */
@RunWith(Parameterized.class)
public class UtopianTreeTest {
    private final int n;
    private final int answer;

    public UtopianTreeTest(int n, int answer) {
        this.n = n;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 1},
                {1, 2},
                {4, 7},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = UtopianTree.solve(1, n);
        assertEquals(answer, myAnswer);
    }
}
