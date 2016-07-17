package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Gemstones} solution.
 */
@RunWith(Parameterized.class)
public class GemstonesTest {
    private final String input;
    private final int expectedNumOfGemElements;

    public GemstonesTest(String input, int expectedNumOfGemElements) {
        this.input = input;
        this.expectedNumOfGemElements = expectedNumOfGemElements;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                // Only "a" and "b" are the two kinds of gem-elements,
                // since these are the only characters that occur in every rock's composition.
                {"3\n"
                    + "abcdde\n"
                    + "baccd\n"
                    + "eeabg", 2},
        });
    }

    @Test
    public void numOfGemElements() throws Exception {
        int actualNumOfGemElements = Gemstones.numOfGemElements(
                new Gemstones.InputSourceIterator(input));
        assertEquals(expectedNumOfGemElements, actualNumOfGemElements);
    }
}