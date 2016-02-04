package com.nohup.epi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link BaseConversion} solution.
 */
@RunWith(Parameterized.class)
public class BaseConversionTest {
    private final String input;
    private final int fromBase;
    private final int toBase;
    private final String expected;

    public BaseConversionTest(String input, int fromBase, int toBase, String expected) {
        this.input = input;
        this.fromBase = fromBase;
        this.toBase = toBase;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"0", 2, 10, "0"},
                {"1", 2, 10, "1"},
                {"11111111", 2, 16, "FF"},
                {"-11111111", 2, 10, "-255"},
        });
    }

    @Test
    public void convertBase() {
        String actual = BaseConversion.solution(input, fromBase, toBase);
        assertEquals(expected, actual);
    }
}