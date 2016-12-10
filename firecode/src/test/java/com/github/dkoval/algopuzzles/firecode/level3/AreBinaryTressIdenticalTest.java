package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link AreBinaryTressIdentical} solution.
 */
@RunWith(Parameterized.class)
public class AreBinaryTressIdenticalTest {
    private final TreeNode root1;
    private final TreeNode root2;
    private final boolean expected;

    public AreBinaryTressIdenticalTest(TreeNode root1, TreeNode root2, boolean expected) {
        this.root1 = root1;
        this.root2 = root2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, null, true},
                {null, new TreeNode(1, null, null), false},
                {new TreeNode(1, null, null), null, false},
                {new TreeNode(1, null, null), new TreeNode(1, null, null), true},
                {new TreeNode(1, null, null), new TreeNode(2, null, null), false},
                {new TreeNode(1,
                        new TreeNode(2, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(1,
                        new TreeNode(2, null, null),
                        new TreeNode(3, new TreeNode(4, null, null), null)), false},
        });
    }

    @Test
    public void isIdentical() throws Exception {
        boolean actual = AreBinaryTressIdentical.isIdentical(root1, root2);
        assertEquals(expected, actual);
    }
}
