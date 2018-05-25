package com.github.dkoval.algopuzzles.codefights;

import com.github.dkoval.algopuzzles.codefights.KthSmallestInBST.Tree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class KthSmallestInBSTTest {
    private final Tree<Integer> root;
    private final int k;
    private final int expected;

    public KthSmallestInBSTTest(Tree<Integer> root, int k, int expected) {
        this.root = root;
        this.k = k;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new Tree<>(20,
                                new Tree<>(8,
                                        new Tree<>(4),
                                        new Tree<>(12,
                                                new Tree<>(10),
                                                new Tree<>(14))),
                                new Tree<>(22)),
                        3,
                        10
                },
                {
                        new Tree<>(20,
                                new Tree<>(8,
                                        new Tree<>(4),
                                        new Tree<>(12,
                                                new Tree<>(10),
                                                new Tree<>(14))),
                                new Tree<>(22)),
                        5,
                        14
                },
                {
                        new Tree<>(3,
                                new Tree<>(1),
                                new Tree<>(5,
                                        new Tree<>(4),
                                        new Tree<>(6))),
                        4,
                        5
                }

        });
    }

    @Test
    public void kthSmallestInBST() {
        int actual = KthSmallestInBST.kthSmallestInBST(root, k);
        assertThat(actual, equalTo(expected));
    }
}