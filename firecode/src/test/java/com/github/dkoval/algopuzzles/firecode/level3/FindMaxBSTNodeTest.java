package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link FindMaxBSTNode} solution.
 */
@RunWith(Parameterized.class)
public class FindMaxBSTNodeTest {
    private final TreeNode root;
    private final Integer expected;

    public FindMaxBSTNodeTest(TreeNode root, Integer expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, null},
                {new TreeNode(5, null, null), 5},
                {new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2, null, null),
                                new TreeNode(4, null, null)),
                        new TreeNode(8,
                                new TreeNode(7, null, null),
                                null)), 8},
        });
    }

    @Test
    public void findMax() throws Exception {
        TreeNode n = FindMaxBSTNode.findMax(root);
        assertEquals(expected, (n != null) ? n.data : null);
    }
}
