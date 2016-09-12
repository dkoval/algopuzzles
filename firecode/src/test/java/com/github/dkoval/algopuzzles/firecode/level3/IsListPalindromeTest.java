package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link IsListPalindrome} solution.
 */
@RunWith(Parameterized.class)
public class IsListPalindromeTest {
    private final ListNode head;
    private final boolean expected;

    public IsListPalindromeTest(ListNode head, boolean expected) {
        this.head = head;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, true},
                {new ListNode(1), true},
                {new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1))))), true},
                {new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3)))), false},
        });
    }

    @Test
    public void isListPalindrome() throws Exception {
        boolean actual = IsListPalindrome.isListPalindrome(head);
        assertEquals(expected, actual);
    }
}
