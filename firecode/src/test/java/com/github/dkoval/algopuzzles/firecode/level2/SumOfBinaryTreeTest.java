package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link SumOfBinaryTree} solution.
 */
@RunWith(Parameterized.class)
public class SumOfBinaryTreeTest {
    private final TreeNode root;
    private final int expected;

    public SumOfBinaryTreeTest(TreeNode root, int expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 0},
                {new TreeNode(4, null, null), 4},
                {new TreeNode(4,
                        new TreeNode(5, null, null),
                        new TreeNode(6, null, null)), 15},
                {new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(5, null, null)),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null))), 28},
        });
    }

    @Test
    public void sum() throws Exception {
        int actual = SumOfBinaryTree.sum(root);
        assertEquals(expected, actual);
    }
}
