package com.github.dkoval.algopuzzles.ctci.ch04;

import com.github.dkoval.algopuzzles.ctci.lib.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Q403ListOfDepth} solution.
 */
@RunWith(Parameterized.class)
public class Q403ListOfDepthTest {
    private final TreeNode<Integer> root;
    private final List<List<Integer>> nodeDepthTable;

    public Q403ListOfDepthTest(TreeNode<Integer> root, List<List<Integer>> nodeDepthTable) {
        this.root = root;
        this.nodeDepthTable = nodeDepthTable;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null, Collections.emptyList()},
                {new TreeNode<>(1), Collections.singletonList(Collections.singletonList(1))},
                {new TreeNode<>(1)
                        .setLeft(new TreeNode<>(2)
                                .setLeft(new TreeNode<>(4))
                                .setRight(new TreeNode<>(5)))
                        .setRight(new TreeNode<>(3)
                                .setLeft(new TreeNode<>(6))),
                Arrays.asList(Collections.singletonList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6))},
        });
    }

    @Test
    public void solution() throws Exception {
        List<List<TreeNode<Integer>>> answer = Q403ListOfDepth.createNodeDepthTable(root);
        List<List<Integer>> myNodesDepthTable = answer.stream().map(nodes -> nodes.stream()
                .map(TreeNode::getData)
                .collect(Collectors.toList()))
                .collect(Collectors.toList());
        assertEquals(nodeDepthTable, myNodesDepthTable);
    }
}
