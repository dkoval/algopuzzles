package com.github.dkoval.algopuzzles.hackerrank.challenges.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link InsertionSortRunningTime} solution.
 */
@RunWith(Parameterized.class)
public class InsertionSortRunningTimeTest {
    private final int[] input;
    private final int numOfShifts;

    public InsertionSortRunningTimeTest(int[] input, int numOfShifts) {
        this.input = input;
        this.numOfShifts = numOfShifts;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 1, 3, 1, 2}, 4},
        });
    }

    @Test
    public void solution() throws Exception {
        int actualNumOfShifts = InsertionSortRunningTime.numOfShifts(input);
        assertEquals(numOfShifts, actualNumOfShifts);
    }
}
