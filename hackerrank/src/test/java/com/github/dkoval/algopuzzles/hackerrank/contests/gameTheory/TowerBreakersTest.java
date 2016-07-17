package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link TowerBreakers} solution.
 */
@RunWith(Parameterized.class)
public class TowerBreakersTest {
    private final int n;
    private final int m;
    private final int answer;

    public TowerBreakersTest(int n, int m, int answer) {
        this.n = n;
        this.m = m;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 2, 2},
                {1, 4, 1},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = TowerBreakers.solve(n, m);
        assertEquals(answer, myAnswer);
    }
}
