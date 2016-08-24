package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link FindNodeInBinaryTreeWithoutRecursion} solution.
 */
@RunWith(Parameterized.class)
public class FindNodeInBinaryTreeWithoutRecursionTest {
    private final TreeNode root;
    private final int val;
    private final Integer expected;

    public FindNodeInBinaryTreeWithoutRecursionTest(TreeNode root, int val, Integer expected) {
        this.root = root;
        this.val = val;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 1, null},
                {new TreeNode(1, null, null), 2, null},
                {new TreeNode(6,
                        new TreeNode(4,
                                new TreeNode(3, null, null),
                                new TreeNode(5, null, null)),
                        new TreeNode(8,
                                null,
                                new TreeNode(9, null, null))), 4, 4},
        });
    }


    @Test
    public void findNode() throws Exception {
        TreeNode actual = FindNodeInBinaryTreeWithoutRecursion.findNode(root, val);
        assertEquals(expected, (actual != null) ? actual.data : null);
    }
}
