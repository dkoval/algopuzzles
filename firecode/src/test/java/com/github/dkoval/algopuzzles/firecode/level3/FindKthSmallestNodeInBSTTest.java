package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.BiFunction;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link FindKthSmallestNodeInBST} solution.
 */
@RunWith(Parameterized.class)
public class FindKthSmallestNodeInBSTTest {
    private final TreeNode root;
    private final int k;
    private final Integer expected;

    public FindKthSmallestNodeInBSTTest(TreeNode root, int k, Integer expected) {
        this.root = root;
        this.k = k;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 1, null},
                {new TreeNode(5, null, null), 1, 5},
                {new TreeNode(1,
                        new TreeNode(-1, null, null),
                        null), 1, -1},
                {new TreeNode(5,
                        new TreeNode(4,
                                new TreeNode(2, null, null),
                                null),
                        new TreeNode(8,
                                null,
                                new TreeNode(10, null, null))), 2, 4},
                {new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                null),
                        new TreeNode(4,
                                null,
                                new TreeNode(5, null, null))), 5, 5},
                {new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2, null, null),
                                new TreeNode(4, null, null)),
                        new TreeNode(8,
                                new TreeNode(7, null, null),
                                new TreeNode(10, null, null))), 2, 3},
                {new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2, null, null),
                                new TreeNode(4, null, null)),
                        new TreeNode(8,
                                new TreeNode(7, null, null),
                                new TreeNode(10, null, null))), 5, 7},
                {new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2, null, null),
                                new TreeNode(4, null, null)),
                        new TreeNode(8,
                                new TreeNode(7, null, null),
                                new TreeNode(10, null, null))), 6, 8},
        });
    }

    private void assertFindKthSmallest(BiFunction<TreeNode, Integer, TreeNode> solution) throws Exception {
        TreeNode actual = solution.apply(root, k);
        assertEquals(expected, (actual != null) ? actual.data : null);
    }

    @Test
    public void findKthSmallestRecursive() throws Exception {
        assertFindKthSmallest(FindKthSmallestNodeInBST::findKthSmallestRecursive);
    }

    @Test
    public void findKthSmallestIterative() throws Exception {
        assertFindKthSmallest(FindKthSmallestNodeInBST::findKthSmallestIterative);
    }
}
