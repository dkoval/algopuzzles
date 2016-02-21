package com.nohup.epi.ch7.lists;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertSame;

/**
 * Tests {@link CheckForCyclicity} solution.
 */
@RunWith(Parameterized.class)
public class CheckForCyclicityTest {
    private final CheckForCyclicity.ListNode<Integer> L;
    private final CheckForCyclicity.ListNode<Integer> startOfCycle;

    public CheckForCyclicityTest(CheckForCyclicity.ListNode<Integer> L,
                                 CheckForCyclicity.ListNode<Integer> startOfCycle) {
        this.L = L;
        this.startOfCycle = startOfCycle;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return asList(
                dataRow0(),
                dataRow1(),
                dataRow2());
    }

    private static Object[] dataRow0() {
        return new Object[]{
            // L
            new CheckForCyclicity.ListNode<>(1,
            new CheckForCyclicity.ListNode<>(2,
            new CheckForCyclicity.ListNode<>(3, null))),

            // the start of cycle
            null
        };
    }

    private static Object[] dataRow1() {
        CheckForCyclicity.ListNode<Integer> head =
                new CheckForCyclicity.ListNode<>(1,
                new CheckForCyclicity.ListNode<>(2,
                new CheckForCyclicity.ListNode<>(3,
                new CheckForCyclicity.ListNode<>(4,
                new CheckForCyclicity.ListNode<>(5, null)))));

        // head 1 -> 2 -> 3 -> 4 -> 5
        //      ^                   |
        //      |                   |
        //      +-------------------+
        head.next.next.next.next.next = head;

        return new Object[]{
            // L
            head,

            // the start of cycle
            head
        };
    }

    private static Object[] dataRow2() {
        CheckForCyclicity.ListNode<Integer> head =
                new CheckForCyclicity.ListNode<>(1,
                new CheckForCyclicity.ListNode<>(2,
                new CheckForCyclicity.ListNode<>(3,
                new CheckForCyclicity.ListNode<>(4,
                new CheckForCyclicity.ListNode<>(5,
                new CheckForCyclicity.ListNode<>(6, null))))));

        // head 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //           ^         |
        //           |         |
        //           +---------+
        head.next.next.next.next = head.next;

        return new Object[]{
                // L
                head,

                // the start of cycle
                head.next
        };
    }

    @Test
    public void hasCycle() {
        CheckForCyclicity.ListNode<Integer> answer = CheckForCyclicity.solution(L);
        assertSame(startOfCycle, answer);
    }
}