package com.nohup.epi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Parity} solution.
 */
public class ParityTest {

    @Test
    public void parity() {
        long probe = System.currentTimeMillis();
        short answer = Parity.solution(probe);
        assertEquals(Long.bitCount(probe) % 2, answer);
    }
}
