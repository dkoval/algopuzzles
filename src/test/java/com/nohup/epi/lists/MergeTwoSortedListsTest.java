package com.nohup.epi.lists;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Tests {@link MergeTwoSortedLists} solution.
 */
@RunWith(Parameterized.class)
public class MergeTwoSortedListsTest {
    private final MergeTwoSortedLists.Node<Integer> L;
    private final MergeTwoSortedLists.Node<Integer> F;
    private final MergeTwoSortedLists.Node<Integer> M;

    public MergeTwoSortedListsTest(MergeTwoSortedLists.Node<Integer> L,
                                   MergeTwoSortedLists.Node<Integer> F,
                                   MergeTwoSortedLists.Node<Integer> M) {
        this.L = L;
        this.F = F;
        this.M = M;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return asList(new Object[][]{
                {
                    // L
                    null,

                    // F
                    new MergeTwoSortedLists.Node<>(4,
                    new MergeTwoSortedLists.Node<>(8, null)),

                    // M
                    new MergeTwoSortedLists.Node<>(4,
                    new MergeTwoSortedLists.Node<>(8, null)),
                },

                {
                    // L
                    new MergeTwoSortedLists.Node<>(1,
                    new MergeTwoSortedLists.Node<>(2,
                    new MergeTwoSortedLists.Node<>(3,
                    new MergeTwoSortedLists.Node<>(5,
                    new MergeTwoSortedLists.Node<>(6, null))))),

                    // F
                    null,

                    // M
                    new MergeTwoSortedLists.Node<>(1,
                    new MergeTwoSortedLists.Node<>(2,
                    new MergeTwoSortedLists.Node<>(3,
                    new MergeTwoSortedLists.Node<>(5,
                    new MergeTwoSortedLists.Node<>(6, null))))),
                },

                {
                    // L
                    new MergeTwoSortedLists.Node<>(1,
                    new MergeTwoSortedLists.Node<>(2,
                    new MergeTwoSortedLists.Node<>(3,
                    new MergeTwoSortedLists.Node<>(5,
                    new MergeTwoSortedLists.Node<>(6, null))))),

                    // F
                    new MergeTwoSortedLists.Node<>(4,
                    new MergeTwoSortedLists.Node<>(8, null)),

                    // M
                    new MergeTwoSortedLists.Node<>(1,
                    new MergeTwoSortedLists.Node<>(2,
                    new MergeTwoSortedLists.Node<>(3,
                    new MergeTwoSortedLists.Node<>(4,
                    new MergeTwoSortedLists.Node<>(5,
                    new MergeTwoSortedLists.Node<>(6,
                    new MergeTwoSortedLists.Node<>(8, null)))))))
                },

                {
                    // L
                    new MergeTwoSortedLists.Node<>(4,
                    new MergeTwoSortedLists.Node<>(8, null)),

                    // F
                    new MergeTwoSortedLists.Node<>(1,
                    new MergeTwoSortedLists.Node<>(2,
                    new MergeTwoSortedLists.Node<>(3,
                    new MergeTwoSortedLists.Node<>(5,
                    new MergeTwoSortedLists.Node<>(6, null))))),

                    // M
                    new MergeTwoSortedLists.Node<>(1,
                    new MergeTwoSortedLists.Node<>(2,
                    new MergeTwoSortedLists.Node<>(3,
                    new MergeTwoSortedLists.Node<>(4,
                    new MergeTwoSortedLists.Node<>(5,
                    new MergeTwoSortedLists.Node<>(6,
                    new MergeTwoSortedLists.Node<>(8, null)))))))
                },
        });
    }

    @Test
    public void mergeTwoSortedLists() throws Exception {
        MergeTwoSortedLists.Node<Integer> answer = MergeTwoSortedLists.solution(L, F);
        assertEquals(M, answer);
    }
}