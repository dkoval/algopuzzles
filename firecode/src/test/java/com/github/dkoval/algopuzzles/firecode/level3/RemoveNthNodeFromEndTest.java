package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests {@link RemoveNthNodeFromEnd} solution.
 */
@RunWith(Parameterized.class)
public class RemoveNthNodeFromEndTest {
    private final ListNode head;
    private final int n;
    private final List<Integer> expected;

    public RemoveNthNodeFromEndTest(ListNode head, int n, List<Integer> expected) {
        this.head = head;
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new ListNode(1), 1, null},
                {new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3, Arrays.asList(1, 2, 4, 5)},
                {null, 3, null},
                {new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 5, Arrays.asList(2, 3, 4, 5)},
                {new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 7, Arrays.asList(1, 2, 3, 4, 5)},
        });
    }

    private void assertRemoveNthFromEnd(BiFunction<ListNode, Integer, ListNode> func) {
        ListNode actual = func.apply(head, n);
        assertThat(ListNode.toList(actual), is(expected));
    }

    @Test
    public void removeNthFromEndInTwoPasses() throws Exception {
        assertRemoveNthFromEnd(RemoveNthNodeFromEnd::removeNthFromEndInTwoPasses);
    }

    @Test
    public void removeNthFromEndInOnePass() throws Exception {
        assertRemoveNthFromEnd(RemoveNthNodeFromEnd::removeNthFromEndInOnePass);
    }
}