package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link FindMaxInBinaryTreeIteratively} solution.
 */
@RunWith(Parameterized.class)
public class FindMaxInBinaryTreeIterativelyTest {
    private final TreeNode root;
    private final int expected;

    public FindMaxInBinaryTreeIterativelyTest(TreeNode root, int expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new TreeNode(4, null, null), 4},
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
    public void findMaxItr() throws Exception {
        int actual = FindMaxInBinaryTreeIteratively.findMaxItr(root);
        assertEquals(expected, actual);
    }
}
