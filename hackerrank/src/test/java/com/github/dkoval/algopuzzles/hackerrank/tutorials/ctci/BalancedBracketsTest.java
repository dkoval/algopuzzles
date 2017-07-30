package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests {@link BalancedBrackets} solution.
 */
@RunWith(Parameterized.class)
public class BalancedBracketsTest {
    private final String expression;
    private final boolean expected;

    public BalancedBracketsTest(String expression, boolean expected) {
        this.expression = expression;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"{[()]}", true},
                {"{[(])}", false},
                {"{{[[(())]]}}", true},
        });
    }

    @Test
    public void isBalanced() throws Exception {
        boolean actual = BalancedBrackets.isBalanced(expression);
        assertThat(actual, is(expected));
    }
}
