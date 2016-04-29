package com.github.dkoval.algopuzzles.hackerrank.contests.worldCodesprintApril;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link BeautifulTriplets} solution.
 */
@RunWith(Parameterized.class)
public class BeautifulTripletsTest {
    private final int[] seq;
    private final int d;
    private final int answer;

    public BeautifulTripletsTest(int[] seq, int d, int answer) {
        this.seq = seq;
        this.d = d;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 5, 7, 8, 10}, 3, 3},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = BeautifulTriplets.solve(seq, d);
        assertEquals(answer, myAnswer);
    }
}