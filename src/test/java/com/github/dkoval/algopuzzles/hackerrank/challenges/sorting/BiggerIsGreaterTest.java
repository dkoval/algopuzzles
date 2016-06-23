package com.github.dkoval.algopuzzles.hackerrank.challenges.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link BiggerIsGreater} solution.
 */
@RunWith(Parameterized.class)
public class BiggerIsGreaterTest {
    private final String s;
    private final String answer;

    public BiggerIsGreaterTest(String s, String answer) {
        this.s = s;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"ab", "ba"},
                {"bb", null},
                {"hefg", "hegf"},
                {"dhck", "dhkc"},
                {"dkhc", "hcdk"},
        });
    }

    @Test
    public void solution() throws Exception {
        String myAnswer = BiggerIsGreater.solve(s);
        assertEquals(answer, myAnswer);
    }
}
