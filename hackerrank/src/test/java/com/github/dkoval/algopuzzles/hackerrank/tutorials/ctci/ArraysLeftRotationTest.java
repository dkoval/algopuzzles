package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Tests {@link ArraysLeftRotation} solution.
 */
@RunWith(Parameterized.class)
public class ArraysLeftRotationTest {
    private final int a[];
    private final int d;
    private final int expected[];

    public ArraysLeftRotationTest(int a[], int d, int expected[]) {
        this.a = a;
        this.d = d;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 4, new int[]{5, 1, 2, 3, 4}},
                {new int[]{1, 2, 3, 4, 5, 6, 7}, 4, new int[]{5, 6, 7, 1, 2, 3, 4}},
        });
    }

    @Test
    public void rotateLeft() throws Exception {
        int actual[] = ArraysLeftRotation.rotateLeft(a, d);
        assertThat(actual, equalTo(expected));
    }
}
