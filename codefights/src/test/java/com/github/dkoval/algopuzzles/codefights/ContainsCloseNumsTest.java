package com.github.dkoval.algopuzzles.codefights;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ContainsCloseNumsTest {
    private final int[] nums;
    private final int k;
    private final boolean expected;

    public ContainsCloseNumsTest(int[] nums, int k, boolean expected) {
        this.nums = nums;
        this.k = k;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new int[]{0, 1, 2, 3, 5, 2},
                        3,
                        true
                },
                {
                        new int[]{0, 1, 2, 3, 5, 2},
                        2,
                        false
                }
        });
    }

    @Test
    public void containsCloseNums() {
        boolean actual = ContainsCloseNums.containsCloseNums(nums, k);
        assertThat(actual, is(equalTo(expected)));
    }
}