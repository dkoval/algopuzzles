package com.github.dkoval.algopuzzles.firecode.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * Tests {@link SelectionSort} solution.
 */
@RunWith(Parameterized.class)
public class SelectionSortTest {
    private final int[] arr;
    private final int[] expected;

    public SelectionSortTest(int[] arr, int[] expected) {
        this.arr = arr;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, new int[]{}},
                {new int[]{11}, new int[]{11}},
                {new int[]{1, 5, 2}, new int[]{1, 2, 5}},
                {new int[]{4, 12, 4, 78, 7, -1}, new int[]{-1, 4, 4, 7, 12, 78}},
        });
    }

    @Test
    public void selectionSortArray() throws Exception {
        int[] actual = SelectionSort.selectionSortArray(arr);
        assertArrayEquals(expected, actual);
    }
}