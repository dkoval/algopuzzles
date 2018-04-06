package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class LonelyIntegerTest {
    private final int[] a;
    private final int expected;

    public LonelyIntegerTest(int[] a, int expected) {
        this.a = a;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1}, 1},
                {new int[]{1, 1, 2}, 2},
                {new int[]{0, 0, 1, 2, 1}, 2}
        });
    }

    @Test
    public void findLonelyInteger() {
        int actual = LonelyInteger.findLonelyInteger(a);
        assertThat(actual, equalTo(expected));
    }
}