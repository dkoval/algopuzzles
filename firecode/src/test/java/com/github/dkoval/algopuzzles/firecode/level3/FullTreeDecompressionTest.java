package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests {@link FullTreeDecompression} solution.
 */
@RunWith(Parameterized.class)
public class FullTreeDecompressionTest {
    private final String str;
    private final TreeNode expected;

    public FullTreeDecompressionTest(String str, TreeNode expected) {
        this.str = str;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"*", null},
                {"1,2,3", new TreeNode(1,
                        new TreeNode(2, null, null),
                        new TreeNode(3, null, null))},
                {"1,2,3,4,*,6,*", new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                null),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                null))},
                {"1,*,2,*,*,*,3", new TreeNode(1,
                        null,
                        new TreeNode(2,
                                null,
                                new TreeNode(3, null, null)))},
        });
    }

    @Test
    public void decompressTree() throws Exception {
        TreeNode actual = FullTreeDecompression.decompressTree(str);
        assertThat(TreeNode.levelOrder(actual), is(TreeNode.levelOrder(expected)));
    }
}
