package com.github.dkoval.algopuzzles.codefights;

import com.github.dkoval.algopuzzles.codefights.RestoreBinaryTree.Tree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.github.dkoval.algopuzzles.codefights.RestoreBinaryTree.Tree.equalTrees;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RestoreBinaryTreeTest {
    private final int[] inorder;
    private final int[] preorder;
    private final Tree<Integer> expected;

    public RestoreBinaryTreeTest(int[] inorder, int[] preorder, Tree<Integer> expected) {
        this.inorder = inorder;
        this.preorder = preorder;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new int[]{4, 2, 1, 5, 3, 6},
                        new int[]{1, 2, 4, 3, 5, 6},
                        new Tree<>(1,
                                new Tree<>(2,
                                        new Tree<>(4),
                                        null),
                                new Tree<>(3,
                                        new Tree<>(5),
                                        new Tree<>(6)))
                }
        });
    }

    @Test
    public void restoreBinaryTree() {
        Tree<Integer> actual = RestoreBinaryTree.restoreBinaryTree(inorder, preorder);
        assertTrue(equalTrees(actual, expected));
    }

    @Test
    public void restoreBinaryTreeImproved() {
        Tree<Integer> actual = RestoreBinaryTree.restoreBinaryTreeImproved(inorder, preorder);
        assertTrue(equalTrees(actual, expected));
    }
}