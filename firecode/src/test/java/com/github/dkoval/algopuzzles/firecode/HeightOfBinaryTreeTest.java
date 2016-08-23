package com.github.dkoval.algopuzzles.firecode;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link HeightOfBinaryTree} solution.
 */
@RunWith(Parameterized.class)
public class HeightOfBinaryTreeTest {
    private final TreeNode root;
    private final int expected;

    public HeightOfBinaryTreeTest(TreeNode root, int expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 0},
                {new TreeNode(1, null, null), 1},
                {new TreeNode(6, new TreeNode(4, null, null), null), 2},
                {new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null)), 2},
                {new TreeNode(6, new TreeNode(4, null, null), new TreeNode(8, new TreeNode(7, null, null) , null)), 3},
        });
    }

    @Test
    public void findHeight() throws Exception {
        int actual = HeightOfBinaryTree.findHeight(root);
        assertEquals(expected, actual);
    }
}
