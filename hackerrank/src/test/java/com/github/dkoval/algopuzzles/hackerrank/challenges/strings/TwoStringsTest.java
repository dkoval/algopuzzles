package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link TwoStrings} solution.
 */
@RunWith(Parameterized.class)
public class TwoStringsTest {
    private final String first;
    private final String second;
    private final boolean answer;

    public TwoStringsTest(String first, String second, boolean answer) {
        this.first = first;
        this.second = second;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"hello", "world", true},
                {"hi", "world", false},
        });
    }

    @Test
    public void solution() throws Exception {
        boolean myAnswer = TwoStrings.thereIsCommonSubstring(first, second);
        assertEquals(answer, myAnswer);
    }
}