package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Tests {@link InsertAtTailOfCircularLinkedList} solution.
 */
@RunWith(Parameterized.class)
public class InsertAtTailOfCircularLinkedListTest {
    private final ListNode head;
    private final int data;
    private final ListNode expected;

    public InsertAtTailOfCircularLinkedListTest(ListNode head, int data, ListNode expected) {
        this.head = head;
        this.data = data;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 1, circularLinkedList(1)},
                {circularLinkedList(1), 2, circularLinkedList(1, 2)},
                {circularLinkedList(1, 2), 3, circularLinkedList(1, 2, 3)},
        });
    }

    private static ListNode circularLinkedList(int... elems) {
        if (elems == null || elems.length == 0) {
            return null;
        }
        ListNode head = new ListNode(elems[0]), curr = head;
        for (int i = 1; i < elems.length; i++) {
            curr.next = new ListNode(elems[i]);
            curr = curr.next;
        }
        curr.next = head;
        return head;
    }

    private static void assertCircularLinkedList(ListNode expected, ListNode actual) {
        if (expected == null) {
            assertNull(actual);
        } else {
            assertNotNull(actual);
            ListNode expectedHead = expected, actualHead = actual;
            while (expected.next != expectedHead) {
                assertEquals(expected.data, actual.data);
                expected = expected.next;
                actual = actual.next;
            }
            assertEquals(expected.data, actual.data);
            assertSame(actualHead, actual.next);
        }
    }

    @Test
    public void insertAtTail() throws Exception {
        ListNode actual = InsertAtTailOfCircularLinkedList.insertAtTail(head, data);
        assertCircularLinkedList(expected, actual);
    }
}
