package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(Parameterized.class)
public class RansomNoteTest {
    private final String[] magazine;
    private final String[] ransom;
    private final boolean expected;

    public RansomNoteTest(String[] magazine, String[] ransom, boolean expected) {
        this.magazine = magazine;
        this.ransom = ransom;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                    new String[]{"give", "me", "one", "grand", "today", "night"},
                    new String[]{"give", "one", "grand", "today"},
                    true
                },
                {
                    new String[]{"two", "times", "three", "is", "not", "four"},
                    new String[]{"two", "times", "two", "is", "four"},
                    false
                }
        });
    }

    @Test
    public void solve() {
        boolean actual = RansomNote.solve(magazine, ransom);
        assertThat(actual, is(expected));
    }
}