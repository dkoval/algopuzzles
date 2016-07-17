package com.github.dkoval.algopuzzles.ctci.ch04;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Q01RouteBetweenNodes} solution.
 */
@RunWith(Parameterized.class)
public class Q01RouteBetweenNodesTest {
    private final Q01RouteBetweenNodes.Graph g;
    private final int start;
    private final int end;
    private final boolean answer;

    public Q01RouteBetweenNodesTest(Q01RouteBetweenNodes.Graph g, int start, int end, boolean answer) {
        this.g = g;
        this.start = start;
        this.end = end;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {createTestGraph(), 3, 5, true},
        });
    }

    private static Q01RouteBetweenNodes.Graph createTestGraph() {
        Q01RouteBetweenNodes.Graph g = new Q01RouteBetweenNodes.Graph(6);
        g.add(new Q01RouteBetweenNodes.Edge(0, 1));
        g.add(new Q01RouteBetweenNodes.Edge(0, 2));
        g.add(new Q01RouteBetweenNodes.Edge(0, 3));
        g.add(new Q01RouteBetweenNodes.Edge(3, 4));
        g.add(new Q01RouteBetweenNodes.Edge(4, 5));
        return g;
    }

    @Test
    public void solution() {
        boolean myAnswer = Q01RouteBetweenNodes.search(g, start, end);
        assertEquals(answer, myAnswer);
    }
}
