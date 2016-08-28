package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests {@link DeleteNodeAtPositionInLinkedList} solution.
 */
@RunWith(Parameterized.class)
public class DeleteNodeAtPositionInLinkedListTest {
    private final ListNode head;
    private final int position;
    private final ListNode expected;

    public DeleteNodeAtPositionInLinkedListTest(ListNode head, int position, ListNode expected) {
        this.head = head;
        this.position = position;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, -1, null},
                {new ListNode(1), 1, null},
                {new ListNode(1, new ListNode(2, new ListNode(3))), 1, new ListNode(2, new ListNode(3))},
                {new ListNode(1, new ListNode(2, new ListNode(3))), 2, new ListNode(1, new ListNode(3))},
                {new ListNode(1, new ListNode(2, new ListNode(3))), 3, new ListNode(1, new ListNode(2))},
                {new ListNode(1, new ListNode(2, new ListNode(3))), 4, new ListNode(1, new ListNode(2, new ListNode(3)))},
        });
    }

    private List<Integer> toJavaList(ListNode head) {
        if (head == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new LinkedList<>();
        ListNode curr = head;
        while (curr != null) {
            res.add(curr.data);
            curr = curr.next;
        }
        return res;
    }

    @Test
    public void deleteAtMiddle() throws Exception {
        ListNode actual = DeleteNodeAtPositionInLinkedList.deleteAtMiddle(head, position);
        assertThat(toJavaList(actual), is(toJavaList(expected)));
    }
}
