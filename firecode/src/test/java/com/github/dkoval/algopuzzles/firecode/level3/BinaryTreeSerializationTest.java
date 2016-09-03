package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests {@link BinaryTreeSerialization} solution.
 */
@RunWith(Parameterized.class)
public class BinaryTreeSerializationTest {
    private final TreeNode root;

    public BinaryTreeSerializationTest(TreeNode root) {
        this.root = root;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new TreeNode(1, null, null)},
                {new TreeNode(1, null, new TreeNode(2, null, null))},
                {new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), null), null)},
                {new TreeNode(1,
                        new TreeNode(2,
                                null,
                                new TreeNode(5, null, null)),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                null))},
                {new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(5, null, null)),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null)))},
                {new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(5,
                                        new TreeNode(2, null, null),
                                        null)),
                        new TreeNode(3,
                                new TreeNode(6,
                                        new TreeNode(1, null, null),
                                        null),
                                new TreeNode(7,
                                        new TreeNode(1, null, null),
                                        null)))},
        });
    }

    @Test
    public void serializeAndThenRestore() throws Exception {
        String serialized = BinaryTreeSerialization.serializeTree(root);
        TreeNode restored = BinaryTreeSerialization.restoreTree(serialized);
        assertThat(TreeNode.levelOrder(root), is(TreeNode.levelOrder(restored)));
    }
}
