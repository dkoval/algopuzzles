package com.github.dkoval.algopuzzles.codefights;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class PossibleSumsTest {
    private final int[] coins;
    private final int[] quantities;
    private final int expected;

    public PossibleSumsTest(int[] coins, int[] quantities, int expected) {
        this.coins = coins;
        this.quantities = quantities;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new int[]{10, 50, 100},
                        new int[]{1, 2, 1},
                        9
                }
        });
    }

    @Test
    public void possibleSums() {
        int actual = PossibleSums.possibleSums(coins, quantities);
        assertThat(actual, equalTo(expected));
    }
}