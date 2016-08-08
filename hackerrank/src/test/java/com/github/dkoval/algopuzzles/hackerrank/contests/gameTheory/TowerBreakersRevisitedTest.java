package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link TowerBreakersRevisited} solution.
 */
@RunWith(Parameterized.class)
public class TowerBreakersRevisitedTest {
    private final int[] h;
    private final int answer;

    public TowerBreakersRevisitedTest(int[] h, int answer) {
        this.h = h;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2}, 1},
                {new int[]{1, 2, 3}, 2},
                {new int[]{3, 8, 4, 6}, 1},
                {new int[]{520186, 207989, 546834, 567829, 184897, 31321, 969804, 842475, 775308, 449856, 939711, 395240, 895029, 926868, 598035, 727436, 922082, 326615, 88513, 570573, 196028, 520952, 45238, 961389, 325404, 844725, 388765, 747489, 271411, 539814, 828925, 586884, 356834, 965473, 280998, 607171, 542819, 276062, 140956, 296341, 802378, 165305, 74568}, 1},
        });
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = TowerBreakersRevisited.solve(h);
        assertEquals(answer, myAnswer);
    }
}
