package com.github.dkoval.algopuzzles.codefights;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class KthLargestElementTest {
    private final int[] nums;
    private final int k;
    private final int expected;

    public KthLargestElementTest(int[] nums, int k, int expected) {
        this.nums = nums;
        this.k = k;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{7, 6, 5, 4, 3, 2, 1}, 2, 6},
                {new int[]{99, 99}, 1, 99},
                {new int[]{-1, 2, 0}, 2, 0},
                {new int[]{-1, 2, 0}, 3, -1},
        });
    }

    @Test
    public void kthLargestElement() {
        int actual = KthLargestElement.kthLargestElement(nums, k);
        assertThat(actual, equalTo(expected));
    }
}