package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link ChocolateFeast} solution.
 */
@RunWith(Parameterized.class)
public class ChocolateFeastTest {
    public final int n;
    public final int c;
    public final int m;
    public final int answer;

    public ChocolateFeastTest(int n, int c, int m, int answer) {
        this.n = n;
        this.c = c;
        this.m = m;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10, 2, 5, 6},
                {12, 4, 4, 3},
                {6, 2, 2, 5},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = ChocolateFeast.solve(n, c, m);
        assertEquals(answer, myAnswer);
    }
}
