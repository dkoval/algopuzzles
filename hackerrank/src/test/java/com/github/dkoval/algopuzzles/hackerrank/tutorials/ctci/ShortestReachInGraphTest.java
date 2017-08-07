package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Tests {@link ShortestReachInGraph} solution.
 */
@RunWith(Parameterized.class)
public class ShortestReachInGraphTest {
    private final ShortestReachInGraph.Graph g;
    private final int s;
    private final int[] expected;

    public ShortestReachInGraphTest(ShortestReachInGraph.Graph g, int s, int[] expected) {
        this.g = g;
        this.s = s;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new ShortestReachInGraph.Graph(4)
                        .addEdge(0, 1)
                        .addEdge(0, 2), 0, new int[]{0, 6, 6, -1}},
                {new ShortestReachInGraph.Graph(3)
                        .addEdge(1, 2), 1, new int[]{-1, 0, 6}},
        });
    }

    @Test
    public void getShortestDistances() throws Exception {
        int[] actual = g.getShortestDistances(s, 6);
        assertThat(actual, equalTo(expected));
    }
}
