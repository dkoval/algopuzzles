package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests {@link PreorderTraversalRecursive} solution.
 */
@RunWith(Parameterized.class)
public class PreorderTraversalRecursiveTest {
    private final TreeNode root;
    private final List<Integer> expected;

    public PreorderTraversalRecursiveTest(TreeNode root, List<Integer> expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, Collections.emptyList()},
                {new TreeNode(4, null, null), Collections.singletonList(4)},
                {new TreeNode(4, new TreeNode(6, null, null), null), Arrays.asList(4, 6)},
                {new TreeNode(6,
                        new TreeNode(4,
                                new TreeNode(3, null, null),
                                null),
                        new TreeNode(8,
                                null,
                                new TreeNode(9, null, null))), Arrays.asList(6, 4, 3, 8, 9)},
                {new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(5, null, null)),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null))), Arrays.asList(1, 2, 4, 5, 3, 6, 7)},
        });
    }

    @Test
    public void preorder() throws Exception {
        PreorderTraversalRecursive problem = new PreorderTraversalRecursive();
        problem.preorder(root);
        assertThat(problem.preorderedList, is(expected));
    }
}