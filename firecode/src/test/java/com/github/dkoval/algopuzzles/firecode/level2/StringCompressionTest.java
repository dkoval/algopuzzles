package com.github.dkoval.algopuzzles.firecode.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link StringCompression} solution.
 */
@RunWith(Parameterized.class)
public class StringCompressionTest {
    private final String text;
    private final String expected;

    public StringCompressionTest(String text, String expected) {
        this.text = text;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, null},
                {"", ""},
                {"aaabbbbbcccc", "a3b5c4"},
                {"aabbbbccc", "a2b4c3"},
                {"abc", "abc"},
        });
    }

    @Test
    public void compressString() throws Exception {
        String actual = StringCompression.compressString(text);
        assertEquals(expected, actual);
    }

    @Test
    public void compressStringRecursively() throws Exception {
        String actual = StringCompression.compressStringRecursively(text);
        assertEquals(expected, actual);
    }
}
