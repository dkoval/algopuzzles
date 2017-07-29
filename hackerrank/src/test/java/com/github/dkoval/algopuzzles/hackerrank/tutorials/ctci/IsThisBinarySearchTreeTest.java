package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Tests {@link IsThisBinarySearchTree} solution.
 */
@RunWith(Parameterized.class)
public class IsThisBinarySearchTreeTest {
    private final IsThisBinarySearchTree.Node root;
    private final boolean expected;

    public IsThisBinarySearchTreeTest(IsThisBinarySearchTree.Node root, boolean expected) {
        this.root = root;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new IsThisBinarySearchTree.Node(4,
                        new IsThisBinarySearchTree.Node(2,
                                new IsThisBinarySearchTree.Node(1, null, null),
                                new IsThisBinarySearchTree.Node(3, null, null)),
                        new IsThisBinarySearchTree.Node(6,
                                new IsThisBinarySearchTree.Node(5, null, null),
                                new IsThisBinarySearchTree.Node(7, null, null))),
                true},
        });
    }

    @Test
    public void checkBST() throws Exception {
        boolean actual = IsThisBinarySearchTree.checkBST(root);
        assertThat(actual, is(expected));
    }
}
