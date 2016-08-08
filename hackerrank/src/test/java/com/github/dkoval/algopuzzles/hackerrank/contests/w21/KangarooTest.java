package com.github.dkoval.algopuzzles.hackerrank.contests.w21;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Kangaroo} solution.
 */
@RunWith(Parameterized.class)
public class KangarooTest {
    private final int x1;
    private final int v1;
    private final int x2;
    private final int v2;
    private final boolean answer;

    public KangarooTest(int x1, int v1, int x2, int v2, boolean answer) {
        this.x1 = x1;
        this.v1 = v1;
        this.x2 = x2;
        this.v2 = v2;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 3, 4, 2, true},
                {0, 2, 5, 3, false},
        });
    }

    @Test
    public void solution() throws Exception {
        boolean myAnswer = Kangaroo.solve(x1, v1, x2, v2);
        assertEquals(answer, myAnswer);
    }
}
