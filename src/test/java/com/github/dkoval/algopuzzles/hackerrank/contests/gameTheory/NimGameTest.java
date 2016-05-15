package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link NimGame} solution.
 */
@RunWith(Parameterized.class)
public class NimGameTest {
    private final int[] s;
    private final int answer;

    public NimGameTest(int[] s, int answer) {
        this.s = s;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[] {1, 1}, 2},
                {new int[] {2, 1, 4}, 1},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = NimGame.solve(s);
        assertEquals(answer, myAnswer);
    }
}
