package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class WeightedUniformStringsTest {
    private final String s;
    private final List<Integer> nums;
    private final List<Boolean> answer;

    public WeightedUniformStringsTest(String s, List<Integer> nums, List<Boolean> answer) {
        this.s = s;
        this.nums = nums;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"abccddde", Arrays.asList(1, 3, 12, 5, 9, 10), Arrays.asList(true, true, true, true, false, false)},
        });
    }

    @Test
    public void hasUniformSubstringOfWeight() {
        Set<Integer> weights = WeightedUniformStrings.allSubStringsWeights(s);
        List<Boolean> actual = nums.stream()
                .map(x -> WeightedUniformStrings.hasUniformSubstringOfWeight(weights, x))
                .collect(toList());
        assertThat(actual, equalTo(answer));
    }
}