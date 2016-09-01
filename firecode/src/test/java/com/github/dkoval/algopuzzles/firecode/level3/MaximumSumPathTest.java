package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link MaximumSumPath} solution.
 */
@RunWith(Parameterized.class)
public class MaximumSumPathTest {
    private final TreeNode root;
    private final int expected;

    public MaximumSumPathTest(TreeNode root, int expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 0},
                {new TreeNode(4, null, null), 4},
                {new TreeNode(6,
                        new TreeNode(4, null, null),
                        new TreeNode(8, null, null)), 18},
                {new TreeNode(4,
                        new TreeNode(40,
                                new TreeNode(41, null, null),
                                null),
                        new TreeNode(45, null, null)), 130},
                {new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(5, null, null)),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null))), 18},
                {new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        new TreeNode(8, null, null),
                                        new TreeNode(9, null, null)),
                                new TreeNode(5, null, null)),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null))), 26},
        });
    }

    @Test
    public void maxSumPath() throws Exception {
        int actual = MaximumSumPath.maxSumPath(root);
        assertEquals(expected, actual);
    }
}
