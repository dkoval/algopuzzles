package com.nohup.epi.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link IntegerStringConversion} solution.
 */
@RunWith(Parameterized.class)
public class IntegerStringConversionTest {
    private final int num;
    private final String str;

    public IntegerStringConversionTest(String str, int num) {
        this.num = num;
        this.str = str;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0", 0},
                {"1", 1},
                {"-1", -1},
                {"7890", 7890},
                {"-7890", -7890},
        });
    }

    @Test
    public void intToString() {
        String answer = IntegerStringConversion.intToString(num);
        assertEquals(str, answer);
    }

    @Test
    public void stringToInt() {
        int answer = IntegerStringConversion.stringToInt(str);
        assertEquals(num, answer);
    }
}