package com.github.dkoval.algopuzzles.codefights;

import com.github.dkoval.algopuzzles.codefights.ReverseNodesInKGroups.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class ReverseNodesInKGroupsTest {
    private final ListNode<Integer> l;
    private final int k;
    private final List<Integer> expected;

    public ReverseNodesInKGroupsTest(ListNode<Integer> l, int k, List<Integer> expected) {
        this.l = l;
        this.k = k;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5))))),
                        1,
                        Arrays.asList(1, 2, 3, 4, 5)
                },
                {
                        new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5))))),
                        2,
                        Arrays.asList(2, 1, 4, 3, 5)
                },
                {
                        new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5, new ListNode<>(6, new ListNode<>(7, new ListNode<>(8, new ListNode<>(9, new ListNode<>(10, new ListNode<>(11))))))))))),
                        3,
                        Arrays.asList(3, 2, 1, 6, 5, 4, 9, 8, 7, 10, 11)
                },
        });
    }

    @Test
    public void reverseNodesInKGroups() {
        ListNode<Integer> actual = ReverseNodesInKGroups.reverseNodesInKGroups(l, k);
        assertThat(actual.values(), equalTo(expected));
    }
}