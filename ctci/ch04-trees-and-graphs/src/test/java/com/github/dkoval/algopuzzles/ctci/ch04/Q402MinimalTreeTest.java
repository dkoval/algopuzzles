package com.github.dkoval.algopuzzles.ctci.ch04;

import com.github.dkoval.algopuzzles.ctci.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Tests {@link Q402MinimalTree} solution.
 */
@RunWith(Parameterized.class)
public class Q402MinimalTreeTest {
    private final Integer elems[];

    public Q402MinimalTreeTest(Integer[] elems) {
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
        TreeNode<Integer> root = Q402MinimalTree.createMinBST(elems);
        assertBST(root);
    }

    private static <T extends Comparable<T>> void assertBST(TreeNode<T> root) {
        assertTrue("Expected Binary Search Tree", isBST(root));
    }

    private static <T extends Comparable<T>> boolean isBST(TreeNode<T> root) {
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
