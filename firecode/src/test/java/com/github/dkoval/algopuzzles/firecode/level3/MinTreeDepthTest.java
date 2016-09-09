package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link MinTreeDepth} solution.
 */
@RunWith(Parameterized.class)
public class MinTreeDepthTest {
    private final TreeNode root;
    private final int expected;

    public MinTreeDepthTest(TreeNode root, int expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new TreeNode(1, null, null), 1},
                {new TreeNode(1,
                        new TreeNode(3,
                                new TreeNode(4, null, null),
                                null),
                        new TreeNode(2, null, null)), 2},
        });
    }

    @Test
    public void minTreeDepth() throws Exception {
        int actual = MinTreeDepth.minTreeDepth(root);
        assertEquals(expected, actual);
    }
}
