package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link NumberOfHalfNodesInBinaryTree} solution.
 */
@RunWith(Parameterized.class)
public class NumberOfHalfNodesInBinaryTreeTest {
    private final TreeNode root;
    private final int expected;

    public NumberOfHalfNodesInBinaryTreeTest(TreeNode root, int expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new TreeNode(1, null, null), 0},
                {new TreeNode(1,
                        new TreeNode(2, null, null),
                        new TreeNode(3, null, null)), 0},
                {new TreeNode(3,
                        null,
                        new TreeNode(9,
                                new TreeNode(4, null, null),
                                null)), 2},
        });
    }

    @Test
    public void numberOfHalfNodes() throws Exception {
        int actual = NumberOfHalfNodesInBinaryTree.numberOfHalfNodes(root);
        assertEquals(expected, actual);
    }
}
