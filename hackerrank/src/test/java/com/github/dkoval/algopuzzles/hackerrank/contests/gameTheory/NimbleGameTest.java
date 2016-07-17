package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link NimbleGame} solution.
 */
@RunWith(Parameterized.class)
public class NimbleGameTest {
    private final int[] c;
    private final int answer;

    public NimbleGameTest(int[] c, int answer) {
        this.c = c;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 2, 3, 0, 6}, 1},
                {new int[]{0, 0, 0, 0}, 2},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = NimbleGame.solve(c);
        assertEquals(answer, myAnswer);
    }
}
