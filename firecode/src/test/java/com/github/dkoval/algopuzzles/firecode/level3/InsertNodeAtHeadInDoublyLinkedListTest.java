package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.DoublyLinkedNode;
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
 * Tests {@link InsertNodeAtHeadInDoublyLinkedList} solution.
 */
@RunWith(Parameterized.class)
public class InsertNodeAtHeadInDoublyLinkedListTest {
    private final DoublyLinkedNode head;
    private final int data;
    private final List<Integer> expected;

    public InsertNodeAtHeadInDoublyLinkedListTest(DoublyLinkedNode head, int data, List<Integer> expected) {
        this.head = head;
        this.data = data;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 1, Collections.singletonList(1)},
                {new DoublyLinkedNode(1), 2, Arrays.asList(2, 1)},
                {DoublyLinkedNode.of(2, 1), 3, Arrays.asList(3, 2, 1)},
        });
    }

    @Test
    public void insertAtHead() throws Exception {
        DoublyLinkedNode actual = InsertNodeAtHeadInDoublyLinkedList.insertAtHead(head, data);
        assertThat(DoublyLinkedNode.toList(actual), is(expected));
    }
}
