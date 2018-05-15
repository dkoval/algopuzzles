package com.github.dkoval.algopuzzles.codefights;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AreFollowingPatternsTest {
    private final String[] strings;
    private final String[] patterns;
    private final boolean expected;

    public AreFollowingPatternsTest(String[] strings, String[] patterns, boolean expected) {
        this.strings = strings;
        this.patterns = patterns;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new String[]{"cat", "dog", "dog"},
                        new String[]{"a", "b", "b"},
                        true
                },
                {
                        new String[]{"cat", "dog", "doggy"},
                        new String[]{"a", "b", "b"},
                        false
                }
        });
    }


    @Test
    public void areFollowingPatterns() {
        boolean actual = AreFollowingPatterns.areFollowingPatterns(strings, patterns);
        assertThat(actual, is(equalTo(expected)));
    }
}