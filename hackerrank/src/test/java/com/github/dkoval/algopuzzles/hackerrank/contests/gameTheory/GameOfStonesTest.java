package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link GameOfStones} solution.
 */
@RunWith(Parameterized.class)
public class GameOfStonesTest {
    private final int n;
    private final int answer;

    public GameOfStonesTest(int n, int answer) {
        this.n = n;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2},
                {2, 1},
                {3, 1},
                {4, 1},
                {5, 1},
                {6, 1},
                {7, 2},
                {10, 1},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = GameOfStones.solve(n);
        assertEquals(answer, myAnswer);
    }
}
