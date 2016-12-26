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
 * Tests {@link FindKthLargestNodeInBST} solution.
 */
@RunWith(Parameterized.class)
public class FindKthLargestNodeInBSTTest {
    private final TreeNode root;
    private final int k;
    private final Integer expected;

    public FindKthLargestNodeInBSTTest(TreeNode root, int k, Integer expected) {
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
                        null), 1, 1},
                {new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                null),
                        new TreeNode(4,
                                null,
                                new TreeNode(5, null, null))), 5, 1},
                {new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2, null, null),
                                new TreeNode(4, null, null)),
                        new TreeNode(8,
                                new TreeNode(7, null, null),
                                new TreeNode(10, null, null))), 2, 8},
                {new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2, null, null),
                                new TreeNode(4, null, null)),
                        new TreeNode(8,
                                new TreeNode(7, null, null),
                                new TreeNode(10, null, null))), 5, 4},
                {new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2, null, null),
                                new TreeNode(4, null, null)),
                        new TreeNode(8,
                                new TreeNode(7, null, null),
                                new TreeNode(10, null, null))), 6, 3},
        });
    }

    private void assertFindKthLargest(BiFunction<TreeNode, Integer, TreeNode> solution) throws Exception {
        TreeNode actual = solution.apply(root, k);
        assertEquals(expected, (actual != null) ? actual.data : null);
    }

    @Test
    public void findKthLargestRecursive() throws Exception {
        assertFindKthLargest(FindKthLargestNodeInBST::findKthLargestRecursive);
    }

    @Test
    public void findKthLargestIterative() throws Exception {
        assertFindKthLargest(FindKthLargestNodeInBST::findKthLargestIterative);
    }
}
