package com.github.dkoval.algopuzzles.firecode.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link MaxGain} solution.
 */
@RunWith(Parameterized.class)
public class MaxGainTest {
    private final int[] arr;
    private final int expected;

    public MaxGainTest(int[] arr, int expected) {
        this.arr = arr;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 50, 10, 100, 30}, 100},
                {new int[]{100, 40, 20, 10}, 0},
                {new int[]{1, 1}, 0},
                {new int[]{0, 100, 0, 100, 0, 100}, 100},
        });
    }

    @Test
    public void maxGain() throws Exception {
        int actual = MaxGain.maxGain(arr);
        assertEquals(expected, actual);
    }
}
