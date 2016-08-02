package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link TimeInWords} solution.
 */
@RunWith(Parameterized.class)
public class TimeInWordsTest {
    private final int h;
    private final int m;
    private final String answer;

    public TimeInWordsTest(int h, int m, String answer) {
        this.h = h;
        this.m = m;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5, 47, "thirteen minutes to six"},
                {5, 0, "five o' clock"},
                {5, 1, "one minute past five"},
                {5, 10, "ten minutes past five"},
                {5, 28, "twenty eight minutes past five"},
                {5, 30, "half past five"},
                {5, 40, "twenty minutes to six"},
                {5, 45, "quarter to six"},
                {5, 47, "thirteen minutes to six"},
        });
    }

    @Test
    public void solution() throws Exception {
        String myAnswer = TimeInWords.solve(h, m);
        assertEquals(answer, myAnswer);
    }
}