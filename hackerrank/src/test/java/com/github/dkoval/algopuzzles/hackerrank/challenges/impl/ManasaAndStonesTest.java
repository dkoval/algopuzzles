package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link ManasaAndStones} solution.
 */
@RunWith(Parameterized.class)
public class ManasaAndStonesTest {
    private final int n;
    private final int a;
    private final int b;
    private final Set<Integer> answer;

    public ManasaAndStonesTest(int n, int a, int b, Set<Integer> answer) {
        this.n = n;
        this.a = a;
        this.b = b;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, 1, 2, new LinkedHashSet<>(Arrays.asList(2, 3, 4))},
                {4, 10, 100, new LinkedHashSet<>(Arrays.asList(30, 120, 210, 300))},
        });
    }

    @Test
    public void solution() throws Exception {
        Set<Integer> myAnswer = ManasaAndStones.doSolve(n, a, b);
        assertEquals(answer, myAnswer);
    }
}
