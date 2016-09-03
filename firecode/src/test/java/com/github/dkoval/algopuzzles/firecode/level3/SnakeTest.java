package com.github.dkoval.algopuzzles.firecode.level3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests {@link Snake} solution.
 */
@RunWith(Parameterized.class)
public class SnakeTest {
    private final int[][] arr;
    private final List<Integer> expected;

    public SnakeTest(int[][] arr, List<Integer> expected) {
        this.arr = arr;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)},
                {new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}
                }, Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)},
                {new int[][]{
                        {1, 2, 3, 4, 5, 6},
                        {7, 8, 9, 10, 11, 12},
                        {13, 14, 15, 16, 17, 18}
                }, Arrays.asList(1, 2, 3, 4, 5, 6, 12, 18, 17, 16, 15, 14, 13, 7, 8, 9, 10, 11)},
        });
    }

    @Test
    public void findSpiral() throws Exception {
        List<Integer> actual = Snake.findSpiral(arr);
        assertThat(actual, is(expected));
    }
}
