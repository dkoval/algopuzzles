package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests {@link MirrorBinaryTree} solution.
 */
@RunWith(Parameterized.class)
public class MirrorBinaryTreeTest {
    private final TreeNode root;
    private final List<Integer> expectedNodeList;

    public MirrorBinaryTreeTest(TreeNode root, List<Integer> expectedNodeList) {
        this.root = root;
        this.expectedNodeList = expectedNodeList;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, Collections.emptyList()},
                {new TreeNode(1, null, null), Collections.singletonList(1)},
                {new TreeNode(1,
                        new TreeNode(2, null, null),
                        new TreeNode(3, null, null)), Arrays.asList(1, 3, 2)},
                {new TreeNode(6,
                        new TreeNode(4,
                                new TreeNode(3, null, null),
                                null) ,
                        null), Arrays.asList(6, 4, 3)},
        });
    }

    @Test
    public void mirror() throws Exception {
        TreeNode mirror = MirrorBinaryTree.mirror(root);
        List<Integer> actualNodesList = TreeNode.levelOrder(mirror);
        assertThat(actualNodesList, is(expectedNodeList));
    }
}
