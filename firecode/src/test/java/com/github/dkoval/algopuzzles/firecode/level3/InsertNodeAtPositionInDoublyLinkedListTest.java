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
public class InsertNodeAtPositionInDoublyLinkedListTest {
    private final DoublyLinkedNode head;
    private final int data;
    private final int pos;
    private final List<Integer> expected;

    public InsertNodeAtPositionInDoublyLinkedListTest(DoublyLinkedNode head, int data, int pos, List<Integer> expected) {
        this.head = head;
        this.data = data;
        this.pos = pos;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 1, 1, Collections.singletonList(1)},
                {null, 1, 3, null},
                {DoublyLinkedNode.of(1), 4, 2, Arrays.asList(1, 4)},
                {DoublyLinkedNode.of(1), 4, 3, Collections.singletonList(1)},
                {DoublyLinkedNode.of(1, 2, 3), 4, 1, Arrays.asList(4, 1, 2, 3)},
                {DoublyLinkedNode.of(1, 2, 3), 4, 2, Arrays.asList(1, 4, 2, 3)},
                {DoublyLinkedNode.of(1, 2, 3), 4, 4, Arrays.asList(1, 2, 3, 4)},
        });
    }

    @Test
    public void insertAtPos() throws Exception {
        DoublyLinkedNode actual = InsertNodeAtPositionInDoublyLinkedList.insertAtPos(head, data, pos);
        assertThat(DoublyLinkedNode.toList(actual), is(expected));
    }
}
