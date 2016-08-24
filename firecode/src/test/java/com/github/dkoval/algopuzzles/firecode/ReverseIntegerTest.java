package com.github.dkoval.algopuzzles.firecode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link ReverseInteger} solution.
 */
@RunWith(Parameterized.class)
public class ReverseIntegerTest {
    private final int x;
    private final int expected;

    public ReverseIntegerTest(int x, int expected) {
        this.x = x;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {-123, -321},
                {123, 321},
                {30, 3},
                {0, 0},
        });
    }

    @Test
    public void reverseInt() throws Exception {
        int actual = ReverseInteger.reverseInt(x);
        assertEquals(expected, actual);
    }

}