package com.github.dkoval.algopuzzles.firecode.level3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link HappyNumbers} solution.
 */
@RunWith(Parameterized.class)
public class HappyNumbersTest {
    private final int n;
    private final boolean expected;

    public HappyNumbersTest(int n, boolean expected) {
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, true},
                {19, true},
                {28, true},
                {100, true},
                {12, false},
                {68, true},
        });
    }

    @Test
    public void isHappyNumber() throws Exception {
        boolean actual = HappyNumbers.isHappyNumber(n);
        assertEquals(expected, actual);
    }
}
