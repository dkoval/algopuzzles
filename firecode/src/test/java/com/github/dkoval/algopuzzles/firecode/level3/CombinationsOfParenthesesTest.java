package com.github.dkoval.algopuzzles.firecode.level3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * Tests {@link CombinationsOfParentheses} solution.
 */
@RunWith(Parameterized.class)
public class CombinationsOfParenthesesTest {
    private final int pairs;
    private final List<String> expected;

    public CombinationsOfParenthesesTest(int pairs, List<String> expected) {
        this.pairs = pairs;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {-1, Collections.emptyList()},
                {0, Collections.emptyList()},
                {1, Collections.singletonList("()")},
                {2, Arrays.asList("(())", "()()")},
                {3, Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()")},
        });
    }

    @Test
    public void combParenthesis() throws Exception {
        ArrayList<String> actual = CombinationsOfParentheses.combParenthesis(pairs);
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }
}
