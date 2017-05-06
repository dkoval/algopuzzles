package com.github.dkoval.algopuzzles.hackerrank.contests.rookierank3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaximalTourismTest {
    private final int n;
    private final int[][] routes;
    private final int expected;

    public MaximalTourismTest(int n, int[][] routes, int expected) {
        this.n = n;
        this.routes = routes;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {8, new int[][]{
                        {1, 2},
                        {7, 4},
                        {7, 3},
                        {5, 8},
                        {1, 3},
                }, 5},
        });
    }

    @Test
    public void solve() throws Exception {
        int actual = MaximalTourism.solve(n, routes);
        assertEquals(expected, actual);
    }
}