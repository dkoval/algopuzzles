package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link PokerNim} solution.
 */
@RunWith(Parameterized.class)
public class PokerNimTest {
    private final int[] c;
    private final int k;
    private final int answer;

    public PokerNimTest(int[] c, int k, int answer) {
        this.c = c;
        this.k = k;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2}, 5, 1},
                {new int[]{2, 1, 3}, 5, 2},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = PokerNim.solve(c, k);
        assertEquals(answer, myAnswer);
    }
}
