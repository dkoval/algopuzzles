package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Tests {@link SumOfBinaryTreeIteratively} solution.
 */
@RunWith(Parameterized.class)
public class SumOfBinaryTreeIterativelyTest {
    private final TreeNode root;
    private final int expected;

    public SumOfBinaryTreeIterativelyTest(TreeNode root, int expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 0},
                {new TreeNode(1, null, null), 1},
                {new TreeNode(1,
                        new TreeNode(2, null, null),
                        new TreeNode(3, null, null)), 6},
        });
    }

    @Test
    public void sumItr() throws Exception {
        int actual = SumOfBinaryTreeIteratively.sumItr(root);
        assertEquals(expected, actual);
    }
}
