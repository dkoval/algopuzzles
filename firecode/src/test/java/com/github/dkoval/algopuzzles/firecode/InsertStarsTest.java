package com.github.dkoval.algopuzzles.firecode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link InsertStars} solution.
 */
@RunWith(Parameterized.class)
public class InsertStarsTest {
    private final String input;
    private final String expected;

    public InsertStarsTest(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"bbb", "b*b*b"},
                {"abbba", "ab*b*ba"},
                {"b", "b"},
                {"abba", "ab*ba"},
                {null, null},
        });
    }

    @Test
    public void insertPaiOrStar() throws Exception {
        String actual = InsertStars.insertPairStar(input);
        assertEquals(expected, actual);
    }
}