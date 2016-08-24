package com.github.dkoval.algopuzzles.firecode.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Anagrams} solution.
 */
@RunWith(Parameterized.class)
public class AnagramsTest {
    private final String input1;
    private final String input2;
    private final boolean expected;

    public AnagramsTest(String input1, String input2, boolean expected) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abc", "cab", true},
                {"b", "b", true},
                {"bd", "cb", false},
                {"hello", "hi", false},
                {"yellow", "llowey", true},
                {"h", "h", true},
                {"abcde", "acdbe", true},
                {null, null, false},
        });
    }

    @Test
    public void isAnagram() throws Exception {
        boolean actual = Anagrams.isAnagram(input1, input2);
        assertEquals(expected, actual);
    }
}
