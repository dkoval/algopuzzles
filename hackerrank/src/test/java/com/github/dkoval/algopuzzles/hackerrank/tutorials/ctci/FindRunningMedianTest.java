package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Tests {@link FindRunningMedian} solution.
 */
@RunWith(Parameterized.class)
public class FindRunningMedianTest {
    private final int[] numbers;
    private final double[] expected;

    public FindRunningMedianTest(int[] numbers, double[] expected) {
        this.numbers = numbers;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{12, 4, 5, 3, 8, 7}, new double[]{12.0, 8.0, 5.0, 4.5, 5.0, 6.0}},
        });
    }

    @Test
    public void runningMedian() throws Exception {
        double[] actual = FindRunningMedian.getMedians(numbers);
        assertThat(actual, equalTo(expected));
    }
}
