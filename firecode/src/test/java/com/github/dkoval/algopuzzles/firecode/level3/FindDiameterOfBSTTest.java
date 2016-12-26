package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link FindDiameterOfBST} solution.
 */
@RunWith(Parameterized.class)
public class FindDiameterOfBSTTest {
    private final TreeNode root;
    private final int expected;

    public FindDiameterOfBSTTest(TreeNode root, int expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 0},
                {new TreeNode(5), 1},
                {new TreeNode(1,
                        new TreeNode(-1),
                        null), 2},
                {new TreeNode(1,
                        null,
                        new TreeNode(2,
                                null,
                                new TreeNode(3))), 3},
                {new TreeNode(1,
                        null,
                        new TreeNode(4,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(3)),
                                new TreeNode(5))), 4},
        });
    }

    private void assertDiameter(Function<TreeNode, Integer> solution) {
        int actual = solution.apply(root);
        assertEquals(expected, actual);
    }

    @Test
    public void diameterNaive() throws Exception {
        assertDiameter(FindDiameterOfBST::diameterNaive);
    }

    @Test
    public void diameterImproved() throws Exception {
        assertDiameter(FindDiameterOfBST::diameterImproved);
    }
}
