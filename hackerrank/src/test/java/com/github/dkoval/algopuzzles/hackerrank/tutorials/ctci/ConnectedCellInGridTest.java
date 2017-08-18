package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Tests {@link ConnectedCellInGrid} solution.
 */
@RunWith(Parameterized.class)
public class ConnectedCellInGridTest {
    private final int[][] grid;
    private final int expected;

    public ConnectedCellInGridTest(int[][] grid, int expected) {
        this.grid = grid;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                    new int[][]{
                        {1, 1, 0, 0},
                        {0, 1, 1, 0},
                        {0, 0, 1, 0},
                        {1, 0, 0, 0},
                }, 5},
        });
    }


    @Test
    public void numCellsInLargestRegion() throws Exception {
        int actual = ConnectedCellInGrid.numCellsInLargestRegion(grid);
        assertThat(actual, equalTo(expected));
    }
}