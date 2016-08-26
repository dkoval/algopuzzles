package com.github.dkoval.algopuzzles.firecode.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * Tests {@link CoupleSum} solution.
 */
@RunWith(Parameterized.class)
public class CoupleSumTest {
    private final int[] numbers;
    private final int target;
    private final int[] expected;

    public CoupleSumTest(int[] numbers, int target, int[] expected) {
        this.numbers = numbers;
        this.target = target;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 3, 4, 7}, 7, new int[]{2, 3}},
                {new int[]{1, 2, 3, 4, 5}, 3, new int[]{1, 2}},
                {new int[]{1, 2, 3, 4, 5}, 9, new int[]{4, 5}},
                {new int[]{1, 2, 3}, 5, new int[]{2, 3}},
                {new int[]{1, 2, 9, 11, 25}, 20, new int[]{3, 4}},
        });
    }

    @Test
    public void coupleSum() throws Exception {
        int[] actual = CoupleSum.coupleSum(numbers, target);
        assertArrayEquals(expected, actual);
    }
}
