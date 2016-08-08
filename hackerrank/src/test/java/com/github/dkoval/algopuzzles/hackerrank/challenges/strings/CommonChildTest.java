package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link CommonChild} solution.
 */
@RunWith(Parameterized.class)
public class CommonChildTest {
    private final String s1;
    private final String s2;
    private final int answer;

    public CommonChildTest(String s1, String s2, int answer) {
        this.s1 = s1;
        this.s2 = s2;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"HARRY", "SALLY", 2},
                {"AA", "BB", 0},
                {"SHINCHAN", "NOHARAAA", 3},
                {"ABCDEF", "FBDAMN", 2},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = CommonChild.solve(s1, s2);
        assertEquals(myAnswer, answer);
    }
}
