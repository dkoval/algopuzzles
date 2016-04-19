package com.github.dkoval.algopuzzles.hackerrank.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * Tests {@link InsertionSortPart2} solution.
 */
@RunWith(Parameterized.class)
public class InsertionSortPart2Test {
    private final int[] input;
    private final int[] output;

    public InsertionSortPart2Test(int[] input, int[] output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 4, 3, 5, 6, 2}, new int[]{1, 2, 3, 4, 5, 6}},
        });
    }

    @Test
    public void insertionSortPart2() throws Exception {
        InsertionSortPart2.insertionSortPart2(input);
        assertArrayEquals(output, input);
    }
}
