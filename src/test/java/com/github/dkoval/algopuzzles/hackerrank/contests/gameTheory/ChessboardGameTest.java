package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link ChessboardGame} solution.
 */
@RunWith(Parameterized.class)
public class ChessboardGameTest {
    private final int x;
    private final int y;
    private final int answer;

    public ChessboardGameTest(int x, int y, int answer) {
        this.x = x;
        this.y = y;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5, 2, 2},
                {5, 3, 1},
                {8, 8, 1},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = ChessboardGame.solve(x, y);
        assertEquals(answer, myAnswer);
    }
}