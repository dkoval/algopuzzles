package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link FindDiameterOfBST} solution.
 */
@RunWith(Parameterized.class)
public class FindDiameterOfBSTTest {
    private final TreeNode root;
    private final int expected;

    public FindDiameterOfBSTTest(TreeNode root, int expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 0},
                {new TreeNode(5), 1},
                {new TreeNode(1,
                        new TreeNode(-1),
                        null), 2},
                {new TreeNode(1,
                        null,
                        new TreeNode(2,
                                null,
                                new TreeNode(3))), 3},
                {new TreeNode(1,
                        null,
                        new TreeNode(4,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(3)),
                                new TreeNode(5))), 4},
        });
    }

    @Test
    public void diameter() throws Exception {
        int actual = FindDiameterOfBST.diameter(root);
        assertEquals(expected, actual);
    }
}
