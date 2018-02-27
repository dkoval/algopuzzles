package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Tests {@link TwoCharacters} solution.
 */
@RunWith(Parameterized.class)
public class TwoCharactersTest {
    private final String s;
    private final int answer;

    public TwoCharactersTest(String s, int answer) {
        this.s = s;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"beabeefeab", 5},
                {"pvmaigytciycvjdhovwiouxxylkxjjyzrcdrbmokyqvsradegswrezhtdyrsyhg", 6},
        });
    }

    @Test
    public void twoCharaters() {
        int actual = TwoCharacters.twoCharaters(s);
        assertThat(actual, equalTo(answer));
    }
}