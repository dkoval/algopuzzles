package com.github.dkoval.algopuzzles.codefights;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(Parameterized.class)
public class CryptarithmTest {
    private final String[] crypt;
    private final char[][] solution;
    private final boolean expected;

    public CryptarithmTest(String[] crypt, char[][] solution, boolean expected) {
        this.crypt = crypt;
        this.solution = solution;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new String[]{"TEN", "TWO", "ONE"},
                        new char[][]{
                                {'O', '1'},
                                {'T', '0'},
                                {'W', '9'},
                                {'E', '5'},
                                {'N', '4'}},
                        false
                },
                {
                        new String[]{"A", "A", "A"},
                        new char[][]{
                                {'A', '0'}},
                        true
                },
        });
    }

    @Test
    public void isCryptSolution() {
        boolean actual = Cryptarithm.isCryptSolution(crypt, solution);
        assertThat(actual, is(equalTo(expected)));
    }
}