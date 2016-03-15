package com.bsmart.algopuzzles.epi.ch5.primitive;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link SwapBits} solution.
 */
@RunWith(Parameterized.class)
public class SwapBitsTest {
    private final long input;
    private final int i;
    private final int j;
    private final long output;

    public SwapBitsTest(long input, int i, int j, long output) {
        this.input = input;
        this.i = i;
        this.j = j;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L, 63, 0, 0b00000000_00000000_00000000_00000000_00000000_00000000_00000000_00000001L},
                {0b01111111_11111111_11111111_11111111_11111111_11111111_11111111_11111111L, 63, 0, 0b11111111_11111111_11111111_11111111_11111111_11111111_11111111_11111110L},
                {0b01111111_11111111_11111111_11111111_11111111_11111111_11111111_01111111L, 15, 7, 0b01111111_11111111_11111111_11111111_11111111_11111111_01111111_11111111L},
                {0b01111111_11111111_11111111_11111111_11111111_11111111_01111111_11111111L, 15, 7, 0b01111111_11111111_11111111_11111111_11111111_11111111_11111111_01111111L},
        });
    }

    @Test
    public void swapBits() {
        long actual = SwapBits.solution(input, i, j);
        assertEquals(output, actual);
    }
}
