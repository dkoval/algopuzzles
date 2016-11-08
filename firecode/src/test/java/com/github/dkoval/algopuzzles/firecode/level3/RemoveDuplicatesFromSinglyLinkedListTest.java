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
 * Tests {@link RemoveDuplicatesFromSinglyLinkedList} solution.
 */
@RunWith(Parameterized.class)
public class RemoveDuplicatesFromSinglyLinkedListTest {
    private final ListNode head;
    private final List<Integer> expected;

    public RemoveDuplicatesFromSinglyLinkedListTest(ListNode head, List<Integer> expected) {
        this.head = head;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, null},
                {new ListNode(1), Collections.singletonList(1)},
                {new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(1)))))), Arrays.asList(1, 2, 4, 3)},
        });
    }

    @Test
    public void removeDuplicates() throws Exception {
        ListNode actual = RemoveDuplicatesFromSinglyLinkedList.removeDuplicates(head);
        assertThat(ListNode.toList(actual), is(expected));
    }
}
