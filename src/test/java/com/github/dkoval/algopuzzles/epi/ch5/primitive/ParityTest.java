package com.github.dkoval.algopuzzles.epi.ch5.primitive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Parity} solution.
 */
public class ParityTest {

    @Test
    public void parity() {
        long probe = 0b1000000000000000000000000000000000000000000000000000000000000000L/*System.currentTimeMillis()*/;
        short answer = Parity.solution(probe);
        assertEquals(Long.bitCount(probe) % 2, answer);
    }
}
