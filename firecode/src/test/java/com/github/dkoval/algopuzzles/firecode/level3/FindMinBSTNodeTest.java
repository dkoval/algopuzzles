package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Tests {@link FindMinBSTNode} solution.
 */
@RunWith(Parameterized.class)
public class FindMinBSTNodeTest {
    private final TreeNode root;
    private final Integer expected;

    public FindMinBSTNodeTest(TreeNode root, Integer expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, null},
                {new TreeNode(4,
                        new TreeNode(2, null, null),
                        new TreeNode(8,
                                new TreeNode(5, null, null),
                                new TreeNode(10, null, null))), 2},
        });
    }

    @Test
    public void findMin() throws Exception {
        TreeNode actual = FindMinBSTNode.findMin(root);
        assertEquals(expected, (actual != null) ? actual.data : null);
        if (actual != null) {
            assertNull(actual.left);
            assertNull(actual.right);
        }
    }
}
