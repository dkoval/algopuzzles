package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link MatrixLayerRotation solution.
 */
@RunWith(Parameterized.class)
public class MatrixLayerRotationTest {
    private final String input;
    private final String output;

    public MatrixLayerRotationTest(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws Exception {
        return Arrays.asList(new Object[][]{
                {   /* Input #0 */
                    "4 4 1\n" +
                    "1 2 3 4\n" +
                    "5 6 7 8\n" +
                    "9 10 11 12\n" +
                    "13 14 15 16",
                    /* Output #0 */
                    "2 3 4 8\n" +
                    "1 7 11 12\n" +
                    "5 6 10 16\n" +
                    "9 13 14 15"
                },
                {
                    /* Input #1 */
                    "4 4 2\n" +
                    "1 2 3 4\n" +
                    "5 6 7 8\n" +
                    "9 10 11 12\n" +
                    "13 14 15 16",
                    /* Output #1 */
                    "3 4 8 12\n" +
                    "2 11 10 16\n" +
                    "1 7 6 15\n" +
                    "5 9 13 14"
                },
                {
                    /* Input #2 */
                    "5 4 7\n" +
                    "1 2 3 4\n" +
                    "7 8 9 10\n" +
                    "13 14 15 16\n" +
                    "19 20 21 22\n" +
                    "25 26 27 28",
                    /* Output #2 */
                    "28 27 26 25\n" +
                    "22 9 15 19\n" +
                    "16 8 21 13\n" +
                    "10 14 20 7\n" +
                    "4 3 2 1"
                },
                {
                    /* Input #3 */
                    "2 2 3\n" +
                    "1 1\n" +
                    "1 1",
                    /* Output #3 */
                    "1 1\n" +
                    "1 1"
                },
        });
    }

    @Test
    public void solution() throws Exception {
        String myAnswer = MatrixLayerRotation.solve(new Scanner(input));
        assertEquals(output, myAnswer);
    }
}
