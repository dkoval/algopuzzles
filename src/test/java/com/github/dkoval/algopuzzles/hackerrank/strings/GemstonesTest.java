package com.github.dkoval.algopuzzles.hackerrank.strings;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Gemstones} solution.
 */
public class GemstonesTest {

    @Test
    public void testNumOfGemElements() throws Exception {
        final String input = "abcdde\n" +
                "baccd\n" +
                "eeabg";

        int actual = Gemstones.numOfGemElements(new Scanner(input), 3);
        // Only "a" and "b" are the two kinds of gem-elements,
        // since these are the only characters that occur in every rock's composition.
        assertEquals(2, actual);
    }
}