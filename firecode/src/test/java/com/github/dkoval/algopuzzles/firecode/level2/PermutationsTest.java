package com.github.dkoval.algopuzzles.firecode.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Permutations} solution.
 */
@RunWith(Parameterized.class)
public class PermutationsTest {
    private final String str1;
    private final String str2;
    private final boolean expected;

    public PermutationsTest(String str1, String str2, boolean expected) {
        this.str1 = str1;
        this.str2 = str2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, null, false},
                {null, "abc", false},
                {"abc", null, false},
                {"ab", "abc", false},
                {"abc", "cba", true},
        });
    }

    @Test
    public void permutation() throws Exception {
        boolean actual = Permutations.permutation(str1, str2);
        assertEquals(expected, actual);
    }
}
