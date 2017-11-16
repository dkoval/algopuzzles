package com.github.dkoval.algopuzzles.hackerrank.contests.w35;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link ThreeDSurfaceArea} solution.
 */
@RunWith(Parameterized.class)
public class ThreeDSurfaceAreaTest {
    private final int[][] a;
    private final int answer;

    public ThreeDSurfaceAreaTest(int[][] a, int answer) {
        this.a = a;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{1}}, 6},
                {new int[][]{{1, 3, 4}, {2, 2, 3}, {1, 2, 4}}, 60},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = ThreeDSurfaceArea.surfaceArea(a);
        assertEquals(answer, myAnswer);
    }
}
