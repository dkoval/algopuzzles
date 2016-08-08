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
    private final boolean answer;

    public FunnyStringTest(String input, boolean answer) {
        this.input = input;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"acxz", true},
                {"bcxz", false},
        });
    }

    @Test
    public void solution() throws Exception {
        boolean myAnswer = FunnyString.isFunny(input);
        assertEquals(answer, myAnswer);
    }
}
