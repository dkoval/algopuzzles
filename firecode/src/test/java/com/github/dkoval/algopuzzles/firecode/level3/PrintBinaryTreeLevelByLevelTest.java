package com.github.dkoval.algopuzzles.firecode.level3;

import com.github.dkoval.algopuzzles.firecode.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Tests {@link PrintBinaryTreeLevelByLevel} solution.
 */
@RunWith(Parameterized.class)
public class PrintBinaryTreeLevelByLevelTest {
    private final TreeNode root;
    private final List<List<Integer>> levelByLevel;

    public PrintBinaryTreeLevelByLevelTest(TreeNode root, List<List<Integer>> levelByLevel) {
        this.root = root;
        this.levelByLevel = levelByLevel;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, Collections.emptyList()},
                {new TreeNode(4, null, null),
                        Collections.singletonList(Collections.singletonList(4))},
                {new TreeNode(6,
                        new TreeNode(4, null, null),
                        new TreeNode(8, null, null)),
                        Arrays.asList(Collections.singletonList(6), Arrays.asList(4, 8))},
                {new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(5, null, null)),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null))),
                        Arrays.asList(Collections.singletonList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6, 7))},
        });
    }

    @Test
    public void printLevelByLevel() throws Exception {
        ArrayList<ArrayList<Integer>> actual = PrintBinaryTreeLevelByLevel.printLevelByLevel(root);
        assertThat(actual, is(levelByLevel));
    }
}
