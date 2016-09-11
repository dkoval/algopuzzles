package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests {@link InorderTraversalIterative} solution.
 */
@RunWith(Parameterized.class)
public class InorderTraversalIterativeTest {
    private final TreeNode root;
    private final List<Integer> expected;

    public InorderTraversalIterativeTest(TreeNode root, List<Integer> expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, Collections.emptyList()},
                {new TreeNode(1, null, null), Collections.singletonList(1)},
                {new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(5, null, null)),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null))), Arrays.asList(4, 2, 5, 1, 6, 3, 7)},
        });
    }

    @Test
    public void inorderItr() throws Exception {
        ArrayList<Integer> actual = InorderTraversalIterative.inorderItr(root);
        assertThat(actual, is(expected));
    }
}
