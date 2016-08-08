package com.github.dkoval.algopuzzles.hackerrank.contests.w20;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link SynchronousShopping} solution.
 */
@RunWith(Parameterized.class)
public class SynchronousShoppingTest {
    private final String input;
    private final int answer;

    public SynchronousShoppingTest(String input, int answer) {
        this.input = input;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"5 5 5\n" +
                        "1 1\n" +
                        "1 2\n" +
                        "1 3\n" +
                        "1 4\n" +
                        "1 5\n" +
                        "1 2 10\n" +
                        "1 3 10\n" +
                        "2 4 10\n" +
                        "3 5 10\n" +
                        "4 5 10", 30},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = SynchronousShopping.solve(new Scanner(input));
        assertEquals(answer, myAnswer);
    }
}
