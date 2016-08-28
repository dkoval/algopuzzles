package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link NumberOfLeavesInBinaryTree} solution.
 */
@RunWith(Parameterized.class)
public class NumberOfLeavesInBinaryTreeTest {
    private final TreeNode root;
    private final int expected;

    public NumberOfLeavesInBinaryTreeTest(TreeNode root, int expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 0},
                {new TreeNode(1, null, null), 1},
                {new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null)), 2},
                {new TreeNode(6, new TreeNode(4, new TreeNode(3, null, null), null), null), 1},
                {new TreeNode(6,
                        new TreeNode(4,
                                new TreeNode(3, null, null),
                                null),
                        new TreeNode(8,
                                null,
                                new TreeNode(9, null, null))), 2},
        });
    }

    @Test
    public void numberOfLeaves() throws Exception {
        int actual = NumberOfLeavesInBinaryTree.numberOfLeaves(root);
        assertEquals(expected, actual);
    }
}