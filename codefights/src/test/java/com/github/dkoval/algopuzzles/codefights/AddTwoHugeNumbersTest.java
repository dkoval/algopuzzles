package com.github.dkoval.algopuzzles.codefights;

import com.github.dkoval.algopuzzles.codefights.AddTwoHugeNumbers.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class AddTwoHugeNumbersTest {
    private final ListNode<Integer> a;
    private final ListNode<Integer> b;
    private final List<Integer> expected;

    public AddTwoHugeNumbersTest(ListNode<Integer> a, ListNode<Integer> b, List<Integer> expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new ListNode<>(9876, new ListNode<>(5432, new ListNode<>(1999))),
                        new ListNode<>(1, new ListNode<>(8001)),
                        Arrays.asList(9876, 5434, 0)
                },
                {
                        new ListNode<>(123, new ListNode<>(4, new ListNode<>(5))),
                        new ListNode<>(100, new ListNode<>(100, new ListNode<>(100))),
                        Arrays.asList(223, 104, 105)
                },
                {
                        new ListNode<>(1),
                        new ListNode<>(9999, new ListNode<>(9999, new ListNode<>(9999, new ListNode<>(9999, new ListNode<>(9999, new ListNode<>(9999)))))),
                        Arrays.asList(1, 0, 0, 0, 0, 0, 0)
                }
        });
    }

    @Test
    public void addTwoHugeNumbers() {
        ListNode<Integer> actual = AddTwoHugeNumbers.addTwoHugeNumbers(a, b);
        assertThat(actual.values(), equalTo(expected));
    }
}