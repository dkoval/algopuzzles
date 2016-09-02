package com.github.dkoval.algopuzzles.firecode.level3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests {@link RangeModule} solution.
 */
@RunWith(Parameterized.class)
public class RangeModuleTest {
    private final ArrayList<RangeModule.Interval> input;
    private final ArrayList<RangeModule.Interval> expected;

    public RangeModuleTest(ArrayList<RangeModule.Interval> input, ArrayList<RangeModule.Interval> expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new ArrayList<RangeModule.Interval>(), new ArrayList<RangeModule.Interval>()},
                {new ArrayList<RangeModule.Interval>() {{
                    add(new RangeModule.Interval(1, 3));
                    add(new RangeModule.Interval(2, 5));
                }}, new ArrayList<RangeModule.Interval>() {{
                    add(new RangeModule.Interval(1, 5));
                }}},
                {new ArrayList<RangeModule.Interval>() {{
                    add(new RangeModule.Interval(3, 5));
                    add(new RangeModule.Interval(1, 2));
                }}, new ArrayList<RangeModule.Interval>() {{
                    add(new RangeModule.Interval(1, 2));
                    add(new RangeModule.Interval(3, 5));
                }}},
                {new ArrayList<RangeModule.Interval>(){{
                    add(new RangeModule.Interval(-5, -3));
                    add(new RangeModule.Interval(-4, -2));
                    add(new RangeModule.Interval(0, 10));
                }}, new ArrayList<RangeModule.Interval>(){{
                    add(new RangeModule.Interval(-5, -2));
                    add(new RangeModule.Interval(0, 10));
                }}},
                {new ArrayList<RangeModule.Interval>(){{
                    add(new RangeModule.Interval(-1, 3));
                    add(new RangeModule.Interval(1, 2));
                    add(new RangeModule.Interval(2, 4));
                }}, new ArrayList<RangeModule.Interval>(){{
                    add(new RangeModule.Interval(-1, -4));
                }}},

        });
    }

    @Test
    public void mergeIntervals() throws Exception {
        ArrayList<RangeModule.Interval> actual = RangeModule.mergeIntervals(input);
        assertThat(expected, is(actual));
    }
}
