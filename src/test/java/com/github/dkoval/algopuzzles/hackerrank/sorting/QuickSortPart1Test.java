package com.github.dkoval.algopuzzles.hackerrank.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Tests {@link QuickSortPart1} solution.
 */
@RunWith(Parameterized.class)
public class QuickSortPart1Test {
    private final int[] input;

    public QuickSortPart1Test(int[] input) {
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{4, 5, 3, 7, 2}},
        });
    }

    @Test
    public void partitionInPlace() throws Exception {
        QuickSortPart1.partitionInPlace(input);
        assertArrayPartitions(input);
    }

    private void assertArrayPartitions(int[] ar) {
        int p = ar[0];
        int left = 0, equal = 0, right = 0;
        for (int elem : ar) {
            if (elem < p) {
                left++;
            } else if (elem > p) {
                right++;
            } else {
                equal++;
            }
        }
        assertTrue(left + equal + right == ar.length);
        assertTrue(left <= equal  && equal <= right);
    }
}
