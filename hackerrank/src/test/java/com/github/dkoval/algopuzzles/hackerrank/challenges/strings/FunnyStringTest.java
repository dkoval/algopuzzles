package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link FunnyString} solution.
 */
@RunWith(Parameterized.class)
public class FunnyStringTest {
    private final String input;
    private final boolean isFunny;

    public FunnyStringTest(String input, boolean isFunny) {
        this.input = input;
        this.isFunny = isFunny;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"acxz", true},
                {"bcxz", false},
        });
    }

    @Test
    public void isFunny() throws Exception {
        boolean answer = FunnyString.isFunny(input);
        assertEquals(isFunny, answer);
    }
}