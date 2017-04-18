package com.github.dkoval.algopuzzles.hackerrank.contests.w31;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ZeroOneGameTest {
    private final int[] sequence;
    private final String expected;

    public ZeroOneGameTest(int[] sequence, String expected) {
        this.sequence = sequence;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 0, 0, 1}, "Bob"},
                {new int[]{1, 0, 1, 0, 1}, "Alice"},
                {new int[]{0, 0, 0, 0, 0, 0}, "Bob"},
                {new int[]{0, 0, 0, 0, 0, 1, 0}, "Alice"},
                {new int[]{0, 0, 0, 1, 0, 1, 1, 0, 0, 1}, "Alice"},
                {new int[]{1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1}, "Bob"},
        });
    }

    @Test
    public void solution() throws Exception {
        String actual = ZeroOneGame.solve(sequence);
        assertEquals(expected, actual);
    }
}