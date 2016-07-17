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
    private final boolean thereIsCommonSubstring;

    public TwoStringsTest(String first, String second, boolean thereIsCommonSubstring) {
        this.first = first;
        this.second = second;
        this.thereIsCommonSubstring = thereIsCommonSubstring;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"hello", "world", true},
                {"hi", "world", false},
        });
    }

    @Test
    public void thereIsCommonSubstring() throws Exception {
        boolean answer = TwoStrings.thereIsCommonSubstring(first, second);
        assertEquals(thereIsCommonSubstring, answer);
    }
}