package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Tests {@link FillInAncestorsOfNodeInBinaryTree} solution.
 */
@RunWith(Parameterized.class)
public class FillInAncestorsOfNodeInBinaryTreeTest {
    private final TreeNode root;
    private final int nodeData;
    private final List<Integer> expected;

    public FillInAncestorsOfNodeInBinaryTreeTest(TreeNode root, int nodeData, List<Integer> expected) {
        this.root = root;
        this.nodeData = nodeData;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 1, Collections.emptyList()},
                {new TreeNode(1, null, null), 1, Collections.emptyList()},
                {new TreeNode(1,
                        new TreeNode(2, null, null),
                        new TreeNode(3, null, null)), 2, Collections.singletonList(1)},
                {new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        new TreeNode(8, null, null),
                                        null),
                                new TreeNode(5, null, null)),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null))), 8, Arrays.asList(4, 2, 1)},
        });
    }

    @Test
    public void printAncestors() throws Exception {
        FillInAncestorsOfNodeInBinaryTree problem = new FillInAncestorsOfNodeInBinaryTree();
        problem.printAncestors(root, nodeData);
        assertThat(problem.ancestorsList, is(expected));
    }

    @Test
    public void printAncestorsStateless() throws Exception {
        List<Integer> actual = FillInAncestorsOfNodeInBinaryTree.printAncestorsStateless(root, nodeData);
        assertThat(actual, is(expected));
    }
}