package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Tests {@link SeparateNumbers} solution.
 */
@RunWith(Parameterized.class)
public class SeparateNumbersTest {
    private final String s;
    private final String answer;

    public SeparateNumbersTest(String s, String answer) {
        this.s = s;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1234", "YES 1"},
                {"91011", "YES 9"},
                {"99100", "YES 99"},
                {"101103", "NO"},
                {"010203", "NO"},
                {"13", "NO"},
                {"1", "NO"},
        });
    }

    @Test
    public void separateNumbers() {
        String actual = SeparateNumbers.separateNumbers(this.s);
        assertThat(actual, equalTo(answer));
    }
}