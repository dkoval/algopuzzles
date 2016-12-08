package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Tests {@link DeepestNode} solution.
 */
@RunWith(Parameterized.class)
public class DeepestNodeTest {
    private final TreeNode root;
    private final Integer expected;

    public DeepestNodeTest(TreeNode root, Integer expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, null},
                {new TreeNode(1, null, null), 1},
                {new TreeNode(1,
                        new TreeNode(2, null, null),
                        new TreeNode(3, null, null)), 3},
                {new TreeNode(6,
                        new TreeNode(4,
                                new TreeNode(3, null, null),
                                null),
                        new TreeNode(8,
                                null,
                                new TreeNode(9, null, null))), 9},
        });
    }

    @Test
    public void findDeepest() throws Exception {
        TreeNode actual = DeepestNode.findDeepest(root);
        if (root == null) {
            assertNull(actual);
        } else {
            assertNotNull(actual);
            assertNull(actual.left);
            assertNull(actual.right);
            assertEquals(expected, (Integer) actual.data);
        }
    }
}
