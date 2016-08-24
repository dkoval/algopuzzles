package com.github.dkoval.algopuzzles.firecode.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * Tests {@link MergeTwoSortedArrays} solution.
 */
@RunWith(Parameterized.class)
public class MergeTwoSortedArraysTest {
    private final int[] arrLeft;
    private final int[] arrRight;
    private final int[] expected;

    public MergeTwoSortedArraysTest(int[] arrLeft, int[] arrRight, int[] expected) {
        this.arrLeft = arrLeft;
        this.arrRight = arrRight;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 4, 7, 12, 32}, new int[]{2, 5, 7, 8}, new int[]{2, 2, 4, 5, 7, 7, 8, 12, 32}},
                {new int[]{2}, new int[]{2}, new int[]{2, 2}},
                {new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6}},
                {new int[]{}, new int[]{2, 4, 7, 12}, new int[]{2, 4, 7, 12}},
                {new int[]{2, 5, 7, 8}, new int[]{2, 4, 7, 12, 32}, new int[]{2, 2, 4, 5, 7, 7, 8, 12, 32}},
        });
    }

    @Test
    public void merge() throws Exception {
        int[] actual = MergeTwoSortedArrays.merge(arrLeft, arrRight);
        assertArrayEquals(expected, actual);
    }
}
