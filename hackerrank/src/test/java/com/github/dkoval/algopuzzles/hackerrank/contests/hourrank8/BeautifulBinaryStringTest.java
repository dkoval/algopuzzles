package com.github.dkoval.algopuzzles.hackerrank.contests.hourrank8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link BeautifulBinaryString} solution.
 */
@RunWith(Parameterized.class)
public class BeautifulBinaryStringTest {
    private final String s;
    private final int answer;

    public BeautifulBinaryStringTest(String s, int answer) {
        this.s = s;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0101010", 2},
                {"01100", 0},
                {"0100101010", 3},
                {"100110110011111101110100011011101000011010111001001011010010110010111011100000000100011111100101010", 11}
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = BeautifulBinaryString.solve(s);
        assertEquals(answer, myAnswer);
    }
}
