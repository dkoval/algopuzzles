package com.github.dkoval.algopuzzles.firecode.level4;

import com.github.dkoval.algopuzzles.firecode.level3.RotateSquareImageClockwiseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

/**
 * Tests {@link Rotate2DMatrixBy90DegreesClockwise} solution.
 */
@RunWith(Parameterized.class)
public class Rotate2DMatrixBy90DegreesClockwiseTest {
    private final int[][] matrix;
    private final int[][] expected;

    public Rotate2DMatrixBy90DegreesClockwiseTest(int[][] matrix, int[][] expected) {
        this.matrix = matrix;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return RotateSquareImageClockwiseTest.data();
    }

    @Test
    public void rotate() throws Exception {
        int[][] actual = Rotate2DMatrixBy90DegreesClockwise.rotate(matrix);
        RotateSquareImageClockwiseTest.assert2DArrayEquals(expected, actual);
    }
}