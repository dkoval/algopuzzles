package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link FindNthNodeFromEnd} solution.
 */
@RunWith(Parameterized.class)
public class FindNthNodeFromEndTest {
    private final ListNode head;
    private final int n;
    private final Integer expected;

    public FindNthNodeFromEndTest(ListNode head, int n, Integer expected) {
        this.head = head;
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 1, null},
                {new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), 2, 3},
                {new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), 10, null},
                {new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), -1, null},
                {new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))), 1, 6},
                {new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))), 3, 4},
                {new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))), 6, 1},
                {new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))), 0, null},
        });
    }

    @Test
    public void findNthNodeFromEnd() throws Exception {
        ListNode actual = FindNthNodeFromEnd.findNthNodeFromEnd(head, n);
        assertEquals(expected, (actual != null) ? actual.data : null);
    }
}
