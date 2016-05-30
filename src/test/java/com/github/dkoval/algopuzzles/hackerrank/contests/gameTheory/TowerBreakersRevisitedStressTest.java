package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.InputStream;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Stress tests {@link TowerBreakersRevisited} solution.
 */
@RunWith(Parameterized.class)
public class TowerBreakersRevisitedStressTest {
    private static final String RESOURCE_DIR = "com/github/dkoval/algopuzzles/hackerrank/contests/gameTheory/";

    private final int[] h;
    private final int answer;

    public TowerBreakersRevisitedStressTest(int[] h, int answer) {
        this.h = h;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> params = new LinkedList<>();
        InputStream isin = TowerBreakersRevisitedStressTest.class.getClassLoader().getResourceAsStream(RESOURCE_DIR + "TowerBreakersRevisited-Test1-In.txt");
        InputStream isout = TowerBreakersRevisitedStressTest.class.getClassLoader().getResourceAsStream(RESOURCE_DIR + "TowerBreakersRevisited-Test1-Out.txt");
        Scanner in = new Scanner(isin), out = new Scanner(isout);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = in.nextInt();
            }
            int answer = out.nextInt();
            params.add(new Object[]{h, answer});
        }
        return params;
    }

    @Test
    public void solution() throws Exception {
        int myAnswer = TowerBreakersRevisited.solve(h);
        assertEquals("Input: " + Arrays.toString(h), answer, myAnswer);
    }
}
