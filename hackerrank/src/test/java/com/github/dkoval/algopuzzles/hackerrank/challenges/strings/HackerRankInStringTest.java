package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Tests {@link HackerRankInString} solution.
 */
@RunWith(Parameterized.class)
public class HackerRankInStringTest {
    private final String s;
    private final String answer;

    public HackerRankInStringTest(String s, String answer) {
        this.s = s;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"hhhhhhhhhhhhaaccckeerrrrrankkk", "YES"},
                {"haacckkerrannkk", "YES"},
                {"haacckkerannk", "NO"},
                {"hereiamstackerrank", "YES"},
                {"hackerworld", "NO"},
        });
    }

    @Test
    public void hackerrankInString() {
        String actual = HackerRankInString.hackerrankInString(s);
        assertThat(actual, equalTo(answer));
    }
}