package com.github.dkoval.algopuzzles.firecode;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link SizeOfBinaryTree} solution.
 */
@RunWith(Parameterized.class)
public class SizeOfBinaryTreeTest {
    private final TreeNode root;
    private final int expected;

    public SizeOfBinaryTreeTest(TreeNode root, int expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 0},
                {new TreeNode(4, null, null), 1},
                {new TreeNode(4,
                        new TreeNode(5, null, null),
                        new TreeNode(6, null, null)), 3},
                {new TreeNode(6,
                        new TreeNode(4,
                                null,
                                new TreeNode(5, null, null)),
                        new TreeNode(8,
                                new TreeNode(7, null, null),
                                null)), 5},
                {new TreeNode(4,
                        new TreeNode(2, null, null),
                        new TreeNode(8,
                                new TreeNode(5, null, null),
                                new TreeNode(10, null, null))), 5},
                {new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(5, null, null)),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null))), 7},
        });
    }

    @Test
    public void size() throws Exception {
        int actual = SizeOfBinaryTree.size(root);
        assertEquals(expected, actual);
    }
}