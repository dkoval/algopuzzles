package com.github.dkoval.algopuzzles.codefights;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SwapLexOrderTest {
    private final String str;
    private final int[][] pairs;
    private final String expected;

    public SwapLexOrderTest(String str, int[][] pairs, String expected) {
        this.str = str;
        this.pairs = pairs;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        "abdc",
                        new int[][]{
                                {1, 4},
                                {3, 4}
                        },
                        "dbca"
                },
                {
                        "fixmfbhyutghwbyezkveyameoamqoi",
                        new int[][]{
                                {8, 5},
                                {10, 8},
                                {4, 18},
                                {20, 12},
                                {5, 2},
                                {17, 2},
                                {13, 25},
                                {29, 12},
                                {22, 2},
                                {17, 11}
                        },
                        "fzxmybhtuigowbyefkvhyameoamqei"
                }
        });
    }


    @Test
    public void swapLexOrder() {
        String actual = SwapLexOrder.swapLexOrder(str, pairs);
        assertThat(actual, equalTo(expected));
    }
}