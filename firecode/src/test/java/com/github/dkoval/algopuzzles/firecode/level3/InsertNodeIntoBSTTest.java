package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Tests {@link InsertNodeIntoBST} solution.
 */
@RunWith(Parameterized.class)
public class InsertNodeIntoBSTTest {
    private final TreeNode root;
    private final int data;
    private final TreeNode expected;

    public InsertNodeIntoBSTTest(TreeNode root, int data, TreeNode expected) {
        this.root = root;
        this.data = data;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {   null,
                    1,
                    new TreeNode(1, null, null)
                },
                {   new TreeNode(4,
                        new TreeNode(2, null, null),
                        new TreeNode(8,
                                new TreeNode(5, null, null),
                                new TreeNode(10, null, null))),
                    6,
                    new TreeNode(4,
                        new TreeNode(2, null, null),
                        new TreeNode(8,
                                new TreeNode(5,
                                        null,
                                        new TreeNode(6, null, null)),
                                new TreeNode(10, null, null)))
                },
        });
    }

    @Test
    public void insert() throws Exception {
        TreeNode actual = InsertNodeIntoBST.insert(root, data);
        assertThat(TreeNode.levelOrder(actual), is(TreeNode.levelOrder(expected)));
    }
}
