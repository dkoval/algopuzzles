package com.github.dkoval.algopuzzles.firecode.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link PowOfTwo} solution.
 */
@RunWith(Parameterized.class)
public class PowOfTwoTest {
    private final int num;
    private final boolean expected;

    public PowOfTwoTest(int num, boolean expected) {
        this.num = num;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {9, false},
                {8, true},
                {5, false},
                {256, true},
                {1, true},
        });
    }

    @Test
    public void isPowOfTwo() throws Exception {
        boolean actual = PowOfTwo.isPowOfTwo(num);
        assertEquals(expected, actual);
    }
}
