package com.github.dkoval.algopuzzles.hackerrank.contests.weekOfCode21;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link LazySorting} solution.
 */
@RunWith(Parameterized.class)
public class LazySortingTest {
    private final int[] seq;
    private final String answer;

    public LazySortingTest(int[] seq, String answer) {
        this.seq = seq;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5, 2}, "2.000000"},
                {new int[]{5, 1, 4, 2, 4, 2}, "180.000000"},
                {new int[]{3, 3, 3, 1}, "4.000000"},
                {new int[]{3, 3, 3, 3, 3}, "1.000000"},
        });
    }

    @Test
    public void solution() throws Exception {
        String myAnswer = LazySorting.solve(seq);
        assertEquals(answer, myAnswer);
    }
}
