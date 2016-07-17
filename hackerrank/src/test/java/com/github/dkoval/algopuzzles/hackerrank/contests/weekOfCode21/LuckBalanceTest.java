package com.github.dkoval.algopuzzles.hackerrank.contests.weekOfCode21;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link LuckBalance} solution.
 */
@RunWith(Parameterized.class)
public class LuckBalanceTest {
    private final String input;
    private final int answer;

    public LuckBalanceTest(String input, int answer) {
        this.input = input;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"6 3\n" +
                        "5 1\n" +
                        "2 1\n" +
                        "1 1\n" +
                        "8 1\n" +
                        "10 0\n" +
                        "5 0\n", 29},
        });
    }

    @Test
    public void solution() throws Exception {
        Scanner in = new Scanner(input);
        int myAnswer = LuckBalance.solve(in);
        assertEquals(answer, myAnswer);
    }
}
