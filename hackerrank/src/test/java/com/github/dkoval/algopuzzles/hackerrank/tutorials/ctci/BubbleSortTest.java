package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class BubbleSortTest {
    private final int[] a;
    private final int expectedNumSwaps;
    private final int expectedFirstElem;
    private final int expectedLastElem;

    public BubbleSortTest(int[] a, int expectedNumSwaps, int expectedFirstElem, int expectedLastElem) {
        this.a = a;
        this.expectedNumSwaps = expectedNumSwaps;
        this.expectedFirstElem = expectedFirstElem;
        this.expectedLastElem = expectedLastElem;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3}, 0, 1, 3},
                {new int[]{3, 2, 1}, 3, 1, 3},
        });
    }


    @Test
    public void bubbleSort() {
        int actualNumSwaps = BubbleSort.bubbleSort(a);
        assertThat(actualNumSwaps, equalTo(expectedNumSwaps));
        assertThat(a[0], equalTo(expectedFirstElem));
        assertThat(a[a.length - 1], equalTo(expectedLastElem));
    }
}