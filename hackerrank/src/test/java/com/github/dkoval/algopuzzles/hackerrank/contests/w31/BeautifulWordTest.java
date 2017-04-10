package com.github.dkoval.algopuzzles.hackerrank.contests.w31;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link BeautifulWord} solution.
 */
@RunWith(Parameterized.class)
public class BeautifulWordTest {
    private final String word;
    private final boolean expected;

    public BeautifulWordTest(String word, boolean expected) {
        this.word = word;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"batman", true},
                {"apple", false},
                {"beauty", false},
                {"abacaba", true},
                {"badd", false},
                {"yes", false}
        });
    }

    @Test
    public void solution() throws Exception {
        boolean actual = BeautifulWord.solve(word);
        assertEquals(expected, actual);
    }
}