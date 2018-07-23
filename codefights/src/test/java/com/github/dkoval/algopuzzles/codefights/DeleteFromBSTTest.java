package com.github.dkoval.algopuzzles.codefights;

import com.github.dkoval.algopuzzles.codefights.DeleteFromBST.Tree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.github.dkoval.algopuzzles.codefights.DeleteFromBST.Tree.equalTrees;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class DeleteFromBSTTest {
    private final Tree<Integer> t;
    private final int[] queries;
    private final Tree<Integer> expected;

    public DeleteFromBSTTest(Tree<Integer> t, int[] queries, Tree<Integer> expected) {
        this.t = t;
        this.queries = queries;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new Tree<>(5,
                                new Tree<>(2,
                                        new Tree<>(1),
                                        new Tree<>(3)),
                                new Tree<>(6,
                                        null,
                                        new Tree<>(8,
                                                new Tree<>(7),
                                                null))),
                        new int[]{4, 5, 6},
                        new Tree<>(3,
                                new Tree<>(2, new Tree<>(1), null),
                                new Tree<>(8, new Tree<>(7), null))
                },
                {
                        null,
                        new int[]{1, 2, 3, 4, 5},
                        null
                },
                {
                        new Tree<>(3,
                                new Tree<>(2),
                                null),
                        new int[]{1, 2, 3, 5},
                        null
                },
                {
                        new Tree<>(3,
                                new Tree<>(2),
                                new Tree<>(5)),
                        new int[]{1, 2, 3, 5},
                        null
                },
                {
                        new Tree<>(3,
                                new Tree<>(2,
                                        new Tree<>(1),
                                        null),
                                new Tree<>(5)),
                        new int[]{3, 2, 1},
                        new Tree<>(5)
                }
        });
    }

    @Test
    public void deleteFromBST() {
        Tree<Integer> actual = DeleteFromBST.deleteFromBST(t, queries);
        assertTrue(equalTrees(actual, expected));
    }
}