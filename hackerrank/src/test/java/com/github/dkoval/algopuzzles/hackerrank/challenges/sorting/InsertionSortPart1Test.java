package com.github.dkoval.algopuzzles.hackerrank.challenges.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * Tests {@link InsertionSortPart1} solution.
 */
@RunWith(Parameterized.class)
public class InsertionSortPart1Test {
    private final int[] input;
    private final int[] output;

    public InsertionSortPart1Test(int[] input, int[] output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 4, 6, 8, 3}, new int[]{2, 3, 4, 6, 8}},
        });
    }

    @Test
    public void insertIntoSorted() throws Exception {
        InsertionSortPart1.insertIntoSorted(input);
        assertArrayEquals(output, input);
    }
}
