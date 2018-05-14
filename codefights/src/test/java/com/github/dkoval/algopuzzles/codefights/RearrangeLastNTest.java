package com.github.dkoval.algopuzzles.codefights;

import com.github.dkoval.algopuzzles.codefights.RearrangeLastN.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class RearrangeLastNTest {
    private final ListNode<Integer> l;
    private final int n;
    private final List<Integer> expected;

    public RearrangeLastNTest(ListNode<Integer> l, int n, List<Integer> expected) {
        this.l = l;
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5))))),
                        3,
                        Arrays.asList(3, 4, 5, 1, 2)
                },
                {
                        new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5, new ListNode<>(6, new ListNode<>(7))))))),
                        1,
                        Arrays.asList(7, 1, 2, 3, 4, 5, 6)
                },
        });
    }

    @Test
    public void rearrangeLastN() {
        ListNode<Integer> actual = RearrangeLastN.rearrangeLastN(l, n);
        assertThat(actual.values(), equalTo(expected));
    }
}