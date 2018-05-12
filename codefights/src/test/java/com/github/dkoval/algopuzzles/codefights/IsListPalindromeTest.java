package com.github.dkoval.algopuzzles.codefights;

import com.github.dkoval.algopuzzles.codefights.IsListPalindrome.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class IsListPalindromeTest {
    private final ListNode<Integer> l;
    private final boolean expected;

    public IsListPalindromeTest(ListNode<Integer> l, boolean expected) {
        this.l = l;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                    null,
                    true
                },
                {
                    new ListNode<>(1),
                    true
                },
                {
                    new ListNode<>(0, new ListNode<>(1, new ListNode<>(0))),
                    true
                },
                {
                    new ListNode<>(1, new ListNode<>(100, new ListNode<>(-100, new ListNode<>(-100, new ListNode<>(100, new ListNode<>(1)))))),
                    true
                },
                {
                    new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(3, new ListNode<>(2))))),
                    false
                },
        });
    }

    @Test
    public void isListPalindrome() {
        boolean actual = IsListPalindrome.isListPalindrome(l);
        assertThat(actual, is(equalTo(expected)));
    }
}