package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests {@link InsertNodeAtPositionInLinkedList} solution.
 */
@RunWith(Parameterized.class)
public class InsertNodeAtPositionInLinkedListTest {
    private final ListNode head;
    private final int data;
    private final int pos;
    private final List<Integer> expected;

    public InsertNodeAtPositionInLinkedListTest(ListNode head, int data, int pos, List<Integer> expected) {
        this.head = head;
        this.data = data;
        this.pos = pos;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 4, 0, Collections.singletonList(4)},
                {new ListNode(9, new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(3))))), 8, 6, Arrays.asList(9, 1, 4, 2, 3, 8)},
                {new ListNode(1, new ListNode(2, new ListNode(3))), 4, 2, Arrays.asList(1, 4, 2, 3)},
                {new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(3)))), 9, 1, Arrays.asList(9, 1, 4, 2, 3)},
        });
    }

    @Test
    public void insertAtPosition() throws Exception {
        ListNode actual = InsertNodeAtPositionInLinkedList.insertAtPosition(head, data, pos);
        assertThat(ListNode.toList(actual), is(expected));
    }
}
