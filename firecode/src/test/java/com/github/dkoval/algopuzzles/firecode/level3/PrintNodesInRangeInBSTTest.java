package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests {@link PrintNodesInRangeInBST} solution.
 */
@RunWith(Parameterized.class)
public class PrintNodesInRangeInBSTTest {
    private final TreeNode root;
    private final int a;
    private final int b;
    private final List<Integer> expected;

    public PrintNodesInRangeInBSTTest(TreeNode root, int a, int b, List<Integer> expected) {
        this.root = root;
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, 1, 1, Collections.emptyList()},
                {new TreeNode(1, null, null), 1, 1, Collections.singletonList(1)},
                {new TreeNode(4,
                        new TreeNode(2, null, null),
                        new TreeNode(8,
                                new TreeNode(5, null, null),
                                new TreeNode(10, null, null))), 2, 8, Arrays.asList(2, 4, 5, 8)},
        });
    }

    @Test
    public void printRange() throws Exception {
        PrintNodesInRangeInBST problem = new PrintNodesInRangeInBST();
        problem.printRange(root, a, b);
        assertThat(problem.rangeList, is(expected));
    }
}
