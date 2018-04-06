package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class MakingAnagramsTest {
    private final String first;
    private final String second;
    private final int expected;

    public MakingAnagramsTest(String first, String second, int expected) {
        this.first = first;
        this.second = second;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"cde", "abc", 4}
        });
    }

    @Test
    public void numberNeeded() {
        int actual = MakingAnagrams.numberNeeded(first, second);
        assertThat(actual, equalTo(expected));
    }
}
