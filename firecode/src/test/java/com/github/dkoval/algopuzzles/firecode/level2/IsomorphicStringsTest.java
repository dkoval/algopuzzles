package com.github.dkoval.algopuzzles.firecode.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Tests {@link IsomorphicStrings} solution.
 */
@RunWith(Parameterized.class)
public class IsomorphicStringsTest {
    private final String input1;
    private final String input2;
    private final boolean expected;

    public IsomorphicStringsTest(String input1, String input2, boolean expected) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, null, false},
                {null, "abc", false},
                {"abc", null, false},
                {"ab", "abc", false},
                {"css", "dll", true},
                {"css", "dle", false},
                {"abcabc", "xyzxyz", true},
                {"abcabc", "xbexyz", false},
        });
    }

    @Test
    public void isIsomorphic() throws Exception {

    }
}
