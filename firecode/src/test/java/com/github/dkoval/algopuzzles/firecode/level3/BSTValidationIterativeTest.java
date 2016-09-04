package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link BSTValidationIterative} solution.
 */
@RunWith(Parameterized.class)
public class BSTValidationIterativeTest {
    private final TreeNode root;
    private final boolean expected;

    public BSTValidationIterativeTest(TreeNode root, boolean expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new TreeNode(20,
                        new TreeNode(15,
                                new TreeNode(14, null, null),
                                new TreeNode(18, null, null)),
                        new TreeNode(30, null, null)), true},
                {new TreeNode(20,
                        new TreeNode(30,
                                new TreeNode(14, null, null),
                                new TreeNode(18, null, null)),
                        new TreeNode(15, null, null)), false},
        });
    }

    @Test
    public void validateBST() throws Exception {
        boolean actual = BSTValidationIterative.validateBST(root);
        assertEquals(expected, actual);
    }
}
