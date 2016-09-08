package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.DoublyLinkedNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests {@link DeleteNodeAtPositionInDoublyLinkedList} solution.
 */
@RunWith(Parameterized.class)
public class DeleteNodeAtPositionInDoublyLinkedListTest {
    private final DoublyLinkedNode head;
    private final int pos;
    private final List<Integer> expected;

    public DeleteNodeAtPositionInDoublyLinkedListTest(DoublyLinkedNode head, int pos, List<Integer> expected) {
        this.head = head;
        this.pos = pos;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 3, null},
                {DoublyLinkedNode.of(1, 2, 3, 4), 6, Arrays.asList(1, 2, 3, 4)},
                {DoublyLinkedNode.of(1, 2, 3, 4), 3, Arrays.asList(1, 2, 4)},
                {DoublyLinkedNode.of(1, 2, 3, 4), 4, Arrays.asList(1, 2, 3)},
                {DoublyLinkedNode.of(1, 2, 3, 4), 1, Arrays.asList(2, 3, 4)},
                {DoublyLinkedNode.of(1), 1, null},
        });
    }

    @Test
    public void deleteAtPos() throws Exception {
        DoublyLinkedNode actual = DeleteNodeAtPositionInDoublyLinkedList.deleteAtPos(head, pos);
        assertThat(DoublyLinkedNode.toList(actual), is(expected));
    }
}
