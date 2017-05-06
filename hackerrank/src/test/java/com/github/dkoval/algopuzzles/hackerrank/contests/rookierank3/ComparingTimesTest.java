package com.github.dkoval.algopuzzles.hackerrank.contests.rookierank3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ComparingTimesTest {
    private final String t1;
    private final String t2;
    private final String expected;

    public ComparingTimesTest(String t1, String t2, String expected) {
        this.t1 = t1;
        this.t2 = t2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"12:12AM", "12:13AM", "First"},
                {"12:05AM", "1:05AM", "First"},
                {"11:15AM", "12:15AM", "Second"},
        });
    }

    @Test
    public void timeCompare() throws Exception {
        String actual = ComparingTimes.timeCompare(t1, t2);
        assertEquals(expected, actual);
    }
}