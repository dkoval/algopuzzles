package com.github.dkoval.algopuzzles.firecode.level2;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link BSTValidation} solution.
 */
@RunWith(Parameterized.class)
public class BSTValidationTest {
    private final TreeNode root;
    private final boolean expected;

    public BSTValidationTest(TreeNode root, boolean expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new TreeNode(3,
                        new TreeNode(2, null, null),
                        new TreeNode(4, null, null)), true},
                {new TreeNode(1,
                        new TreeNode(2, null, null),
                        new TreeNode(3, null, null)), false},
                {new TreeNode(20,
                        new TreeNode(15,
                                new TreeNode(10, null, null),
                                new TreeNode(30, null, null)),
                        new TreeNode(40, null, null)), false},
        });
    }

    @Test
    public void validateBST() throws Exception {
        boolean actual = BSTValidation.validateBST(root);
        assertEquals(expected, actual);
    }
}