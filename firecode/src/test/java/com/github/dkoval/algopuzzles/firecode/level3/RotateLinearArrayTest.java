package com.github.dkoval.algopuzzles.firecode.level3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * Tests {@link RotateLinearArray} solution.
 */
@RunWith(Parameterized.class)
public class RotateLinearArrayTest {
    private final int[] arr;
    private final int k;
    private final int[] expected;

    public RotateLinearArrayTest(int[] arr, int k, int[] expected) {
        this.arr = arr;
        this.k = k;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 2, new int[]{3, 4, 5, 1, 2}},
                {new int[]{1}, 7, new int[]{1}},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4, new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4}},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 1}},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 14, new int[]{6, 7, 8, 9, 1, 2, 3, 4, 5}},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2, new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}},
        });
    }

    @Test
    public void rotateLeft() throws Exception {
        int[] actual = RotateLinearArray.rotateLeft(arr, k);
        assertArrayEquals(expected, actual);
    }
}
