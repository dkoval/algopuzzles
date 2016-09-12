package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link DetectCycleInList} solution.
 */
@RunWith(Parameterized.class)
public class DetectCycleInListTest {
    private final ListNode head;
    private final boolean expected;

    public DetectCycleInListTest(ListNode head, boolean expected) {
        this.head = head;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, false},
                {new ListNode(1), false},
                {new ListNode(1, new ListNode(2)), false},
                {createCyclicList(), true}
        });
    }

    private static ListNode createCyclicList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, new ListNode(3, head));
        return head;
    }

    @Test
    public void isCyclic() throws Exception {
        boolean actual = DetectCycleInList.isCyclic(head);
        assertEquals(expected, actual);
    }
}
