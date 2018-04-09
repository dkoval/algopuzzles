package com.github.dkoval.algopuzzles.hackerrank.challenges.bits;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class TwosComplimentTest {
    private final int a;
    private final int b;
    private final long expected;

    public TwosComplimentTest(int a, int b, long expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {-2, 0, 63},
                {-3, 4, 99},
                {-1, 4, 37},
        });
    }

    @Test
    public void twosCompliment() {
        long actual = TwosCompliment.twosCompliment(a, b);
        assertThat(actual, equalTo(expected));
    }
}