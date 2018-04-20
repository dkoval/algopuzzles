package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class DavisStaircaseTest {
    private final int n;
    private final int expected;

    public DavisStaircaseTest(int n, int expected) {
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {3, 4},
                {7, 44},
        });
    }

    @Test
    public void numWaysToClimbStaircase() {
        int actual = DavisStaircase.numWaysToClimbStaircase(n);
        assertThat(actual, equalTo(expected));
    }
}
