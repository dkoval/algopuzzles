package com.github.dkoval.algopuzzles.firecode.level3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link MaxRepetition} solution.
 */
@RunWith(Parameterized.class)
public class MaxRepetitionTest {
    private final int[] a;
    private final int expected;

    public MaxRepetitionTest(int[] a, int expected) {
        this.a = a;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0}, 0},
                {new int[]{1, 1}, 1},
                {new int[]{0, 1, 2, 2, 3, 3, 3, 4}, 3},
                {new int[]{3, 6, 1, 2, 5, 7, 4, 6, 2, 6}, 6},
        });
    }

    @Test
    public void getMaxRepetition() throws Exception {
        int actual = MaxRepetition.getMaxRepetition(a);
        assertEquals(expected, actual);
    }
}
