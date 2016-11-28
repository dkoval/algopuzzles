package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests {@link LevelorderTraversal} solution.
 */
@RunWith(Parameterized.class)
public class LevelorderTraversalTest {
    private final TreeNode root;
    private final List<Integer> expected;

    public LevelorderTraversalTest(TreeNode root, List<Integer> expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, Collections.emptyList()},
                {new TreeNode(4, null, null), Collections.singletonList(4)},
                {new TreeNode(6,
                        new TreeNode(4, null, null),
                        new TreeNode(8, null, null)), Arrays.asList(6, 4, 8)},
                {new TreeNode(6,
                        new TreeNode(4,
                                new TreeNode(3, null, null),
                                null),
                        new TreeNode(8,
                                null,
                                new TreeNode(9, null, null))), Arrays.asList(6, 4, 8, 3, 9)},
                {new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(5, null, null)),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null))), Arrays.asList(1, 2, 3, 4, 5, 6, 7)},
                {new TreeNode(4,
                        new TreeNode(2, null, null),
                        new TreeNode(8,
                                new TreeNode(5, null, null),
                                new TreeNode(10, null, null))), Arrays.asList(4, 2, 8, 5, 10)},
        });
    }

    @Test
    public void levelorder() throws Exception {
        ArrayList<Integer> actual = LevelorderTraversal.levelorder(root);
        assertThat(actual, is(expected));
    }
}
