package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link ACMICPCTeam} solution.
 */
@RunWith(Parameterized.class)
public class ACMICPCTeamTest {
    private final String input;
    private final ACMICPCTeam.Answer answer;

    public ACMICPCTeamTest(String input, ACMICPCTeam.Answer answer) {
        this.input = input;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"4 5\n" +
                        "10101\n" +
                        "11100\n" +
                        "11010\n" +
                        "00101\n", new ACMICPCTeam.Answer(5, 2)},
        });
    }

    @Test
    public void solution() throws Exception {
        ACMICPCTeam.Answer myAnswer = ACMICPCTeam.solve(new Scanner(input));
        assertEquals(answer, myAnswer);
    }
}
