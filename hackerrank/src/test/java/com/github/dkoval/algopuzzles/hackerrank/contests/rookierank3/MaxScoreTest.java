package com.github.dkoval.algopuzzles.hackerrank.contests.rookierank3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaxScoreTest {
    private final long[] numbers;
    private final long expected;

    public MaxScoreTest(long[] numbers, long expected) {
        this.numbers = numbers;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new long[]{4, 8, 5}, 6},
        });
    }

    @Test
    public void getMaxScore() throws Exception {
        long actual = MaxScore.getMaxScore(numbers);
        assertEquals(expected, actual);
    }
}