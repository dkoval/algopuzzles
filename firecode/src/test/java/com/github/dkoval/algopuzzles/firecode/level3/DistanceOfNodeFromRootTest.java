package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link DistanceOfNodeFromRoot} solution.
 */
@RunWith(Parameterized.class)
public class DistanceOfNodeFromRootTest {
    private static final TreeNode root1;
    private static final TreeNode root2;

    private final TreeNode root;
    private final int n1;
    private final int expected;

    static {
        root1 = new TreeNode(1,
                    new TreeNode(2,
                            new TreeNode(4, null, null),
                            new TreeNode(5, null, null)),
                    new TreeNode(3,
                            new TreeNode(6, null, null),
                            new TreeNode(7, null, null)));

        root2 = new TreeNode(1,
                    new TreeNode(2,
                            new TreeNode(4, null, null),
                            new TreeNode(5,
                                    new TreeNode(8, null, null),
                                    null)),
                    new TreeNode(3,
                            new TreeNode(6,
                                    new TreeNode(9, null, null),
                                    null),
                            new TreeNode(7,
                                    new TreeNode(10, null, null),
                                    null)));
    }

    public DistanceOfNodeFromRootTest(TreeNode root, int n1, int expected) {
        this.root = root;
        this.n1 = n1;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {root1, 2, 2},
                {root1, 5, 3},
                {root1, 6, 3},
                {root1, 7, 3},
                {root2, 6, 3},
                {root2, 10, 4},
                {new TreeNode(1,
                        null,
                        new TreeNode(2, null, null)), 1, 1},
                {new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3, null, null),
                                null),
                        null), 1, 1},
        });
    }

    @Test
    public void pathLengthFromRoot() throws Exception {
        int actual = DistanceOfNodeFromRoot.pathLengthFromRoot(root, n1);
        assertEquals(expected, actual);
    }
}
