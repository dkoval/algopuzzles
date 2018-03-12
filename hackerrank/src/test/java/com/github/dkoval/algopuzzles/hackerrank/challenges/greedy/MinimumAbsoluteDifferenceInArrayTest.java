package com.github.dkoval.algopuzzles.hackerrank.challenges.greedy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class MinimumAbsoluteDifferenceInArrayTest {
    private final int[] arr;
    private final int expected;

    public MinimumAbsoluteDifferenceInArrayTest(int[] arr, int expected) {
        this.arr = arr;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, -7, 0}, 3},
                {new int[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}, 1},
        });
    }

    @Test
    public void minimumAbsoluteDifference() {
        int actual = MinimumAbsoluteDifferenceInArray.minimumAbsoluteDifference(arr.length, arr);
        assertThat(actual, equalTo(expected));
    }
}