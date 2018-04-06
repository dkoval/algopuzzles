package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class IceCreamParlorTest {
    private final int[] flavors;
    private final int money;
    private final int[] expected;

    public IceCreamParlorTest(int[] flavors, int money, int[] expected) {
        this.flavors = flavors;
        this.money = money;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 4, 5, 3, 2}, 4, new int[]{1, 4}},
                {new int[]{2, 2, 4, 3}, 4, new int[]{1, 2}}
        });
    }


    @Test
    public void solve() {
        int[] actual = IceCreamParlor.solve(flavors, money);
        assertThat(actual, equalTo(expected));
    }
}