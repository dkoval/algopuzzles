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
 * Tests {@link ReverseSinglyLinkedList} solution.
 */
@RunWith(Parameterized.class)
public class ReverseSinglyLinkedListTest {
    private final ListNode head;
    private final List<Integer> expected;

    public ReverseSinglyLinkedListTest(ListNode head, List<Integer> expected) {
        this.head = head;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, null},
                {new ListNode(1), Collections.singletonList(1)},
                {new ListNode(1, new ListNode(2)), Arrays.asList(2, 1)},
                {new ListNode(1, new ListNode(2, new ListNode(3))), Arrays.asList(3, 2, 1)},
        });
    }

    @Test
    public void reverseList() throws Exception {
        ListNode actual = ReverseSinglyLinkedList.reverseList(head);
        assertThat(ListNode.toList(actual), is(expected));
    }
}
