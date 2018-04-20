package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class PrimalityTest {
    private final int n;
    private final boolean expected;

    public PrimalityTest(int n, boolean expected) {
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, false},
                {2, true},
                {3, true},
                {12, false},
                {5, true},
                {7, true},
        });
    }


    @Test
    public void isPrime() {
        boolean actual = Primality.isPrime(n);
        assertThat(actual, is(expected));
    }
}