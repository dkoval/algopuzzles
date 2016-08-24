package com.github.dkoval.algopuzzles.firecode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Tests {@link TransposeOfSquareMatrix} solution.
 */
@RunWith(Parameterized.class)
public class TransposeOfSquareMatrixTest {
    private final int[][] matrix;
    private final int[][] expected;

    public TransposeOfSquareMatrixTest(int[][] matrix, int[][] expected) {
        this.matrix = matrix;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{1, 0}, {0, 0}}, new int[][]{{1, 0}, {0, 0}}},
                {new int[][]{{1, 0, 1}, {1, 0, 1}, {1, 0, 1}}, new int[][]{{1, 1, 1}, {0, 0, 0}, {1, 1, 1}}},
                {new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}},
                {new int[][]{{1}}, new int[][]{{1}}},
        });
    }

    private static void assert2DArrayEquals(int[][] expected, int[][] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void transposeMatrix() throws Exception {
        TransposeOfSquareMatrix.transposeMatrix(matrix);
        assert2DArrayEquals(expected, matrix);
    }
}
