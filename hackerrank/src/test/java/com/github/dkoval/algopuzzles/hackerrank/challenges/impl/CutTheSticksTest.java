package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link CutTheSticks} solution.
 */
@RunWith(Parameterized.class)
public class CutTheSticksTest {
    private final List<Integer> sticks;
    private final List<Integer> answer;

    public CutTheSticksTest(List<Integer> sticks, List<Integer> answer) {
        this.sticks = sticks;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(5, 4, 4, 2, 2, 8), Arrays.asList(6, 4, 2, 1)},
                {Arrays.asList(1, 2, 3, 4, 3, 3, 2, 1), Arrays.asList(8, 6, 4, 1)},
        });
    }

    @Test
    public void solution() throws Exception {
        List<Integer> myAnswer = CutTheSticks.solve(new LinkedList<>(sticks));
        assertEquals(answer, myAnswer);
    }
}
