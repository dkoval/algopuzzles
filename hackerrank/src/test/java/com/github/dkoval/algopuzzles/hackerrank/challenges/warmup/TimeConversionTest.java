package com.github.dkoval.algopuzzles.hackerrank.challenges.warmup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link TimeConversionTest} solution.
 */
@RunWith(Parameterized.class)
public class TimeConversionTest {
    private final String time12Hour;
    private final String answer;

    public TimeConversionTest(String time12Hour, String answer) {
        this.time12Hour = time12Hour;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"07:05:45PM", "19:05:45"},
                {"12:05:39AM", "00:05:39"},
        });
    }

    @Test
    public void solution() throws Exception {
        String myAnswer = TimeConversion.solve(time12Hour);
        assertEquals(answer, myAnswer);
    }
}