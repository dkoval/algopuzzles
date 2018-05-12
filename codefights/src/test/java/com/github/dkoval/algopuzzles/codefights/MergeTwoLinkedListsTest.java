package com.github.dkoval.algopuzzles.codefights;

import com.github.dkoval.algopuzzles.codefights.MergeTwoLinkedLists.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class MergeTwoLinkedListsTest {
    private final ListNode<Integer> l1;
    private final ListNode<Integer> l2;
    private final List<Integer> expected;

    public MergeTwoLinkedListsTest(ListNode<Integer> l1, ListNode<Integer> l2, List<Integer> expected) {
        this.l1 = l1;
        this.l2 = l2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new ListNode<>(1, new ListNode<>(2, new ListNode<>(3))),
                        new ListNode<>(4, new ListNode<>(5, new ListNode<>(6))),
                        Arrays.asList(1, 2, 3, 4, 5, 6)
                },
                {
                        new ListNode<>(1, new ListNode<>(1, new ListNode<>(2, new ListNode<>(4)))),
                        new ListNode<>(0, new ListNode<>(3, new ListNode<>(5))),
                        Arrays.asList(0, 1, 1, 2, 3, 4, 5)
                },
                {
                        new ListNode<>(1, new ListNode<>(1)),
                        new ListNode<>(2, new ListNode<>(4)),
                        Arrays.asList(1, 1, 2, 4)
                },
        });
    }

    @Test
    public void mergeTwoLinkedLists() {
        ListNode<Integer> actual = MergeTwoLinkedLists.mergeTwoLinkedLists(l1, l2);
        assertThat(actual.values(), equalTo(expected));
    }
}