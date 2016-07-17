package com.github.dkoval.algopuzzles.ctci.ch04;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Tests {@link Q02MinimalTree} solution.
 */
@RunWith(Parameterized.class)
public class Q02MinimalTreeTest {
    private final Integer elems[];

    public Q02MinimalTreeTest(Integer[] elems) {
        this.elems = elems;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}},
        });
    }

    @Test
    public void solution() throws Exception {
        Q02MinimalTree.TreeNode<Integer> root = Q02MinimalTree.createMinBST(elems);
        assertBST(root);
    }

    private static <T extends Comparable<T>> void assertBST(Q02MinimalTree.TreeNode<T> root) {
        assertTrue("Expected Binary Search Tree", isBST(root));
    }

    private static <T extends Comparable<T>> boolean isBST(Q02MinimalTree.TreeNode<T> root) {
        if (root.left() != null) {
            if (root.data().compareTo(root.left().data()) < 0 || !isBST(root.left())) {
                return false;
            }
        }
        if (root.right() != null) {
            if (root.data().compareTo(root.right().data()) >= 0 || !isBST(root.right())) {
                return false;
            }
        }
        return true;
    }
}
