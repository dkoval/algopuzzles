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

    private static void assertBST(TreeNode<Integer> root) {
        assertTrue("Expected Binary Search Tree", isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static <T extends Comparable<T>> boolean isBST(TreeNode<T> root, T min, T max) {
        return (root == null) || isBSTHelper(root, min, max);
    }

    private static <T extends Comparable<T>> boolean isBSTHelper(TreeNode<T> root, T min, T max) {
        if (root.getLeft() != null) {
            if (root.getData().compareTo(root.getLeft().getData()) < 0 || !isBSTHelper(root.getLeft(), min, root.getData())) {
                return false;
            }
        }
        if (root.getRight() != null) {
            if (root.getData().compareTo(root.getRight().getData()) >= 0 || !isBSTHelper(root.getRight(), root.getData(), max)) {
                return false;
            }
        }
        return true;
    }
}
