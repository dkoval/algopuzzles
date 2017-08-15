package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Tests {@link Comparator} solution.
 */
@RunWith(Parameterized.class)
public class ComparatorTest {
    private final Comparator.Player[] input;
    private final Comparator.Player[] expected;

    public ComparatorTest(Comparator.Player[] input, Comparator.Player[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                    new Comparator.Player[]{
                            new Comparator.Player("amy", 100),
                            new Comparator.Player("david", 100),
                            new Comparator.Player("heraldo", 50),
                            new Comparator.Player("aakansha", 75),
                            new Comparator.Player("aleksa", 150),
                    },
                    new Comparator.Player[]{
                            new Comparator.Player("aleksa", 150),
                            new Comparator.Player("amy", 100),
                            new Comparator.Player("david", 100),
                            new Comparator.Player("aakansha", 75),
                            new Comparator.Player("heraldo", 50),
                    }
                },
        });
    }

    @Test
    public void checker() throws Exception {
        Arrays.sort(input, new Comparator.Checker());
        assertThat(input, equalTo(expected));
    }
}