package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link IsListEven} solution.
 */
@RunWith(Parameterized.class)
public class IsListEvenTest {
    private final ListNode head;
    private final Boolean expected;

    public IsListEvenTest(ListNode head, Boolean expected) {
        this.head = head;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, true},
                {new ListNode(1), false},
                {new ListNode(1, new ListNode(2)), true},
                {new ListNode(1, new ListNode(2, new ListNode(3))), false},
        });
    }


    @Test
    public void isListEven() throws Exception {
        Boolean actual = IsListEven.isListEven(head);
        assertEquals(expected, actual);
    }
}
