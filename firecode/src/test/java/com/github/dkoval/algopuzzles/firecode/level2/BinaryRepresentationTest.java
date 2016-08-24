package com.github.dkoval.algopuzzles.firecode.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link BinaryRepresentation} solution.
 */
@RunWith(Parameterized.class)
public class BinaryRepresentationTest {
    private final int input;
    private final String expected;

    public BinaryRepresentationTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {15, "1111"},
                {10, "1010"},
                {52, "110100"},
                {0, "0"},
                {1, "1"},
        });
    }

    @Test
    public void computeBinary() throws Exception {
        String actual = BinaryRepresentation.computeBinary(input);
        assertEquals(expected, actual);
    }
}
