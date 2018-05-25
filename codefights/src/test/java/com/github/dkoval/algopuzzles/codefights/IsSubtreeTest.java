package com.github.dkoval.algopuzzles.codefights;

import com.github.dkoval.algopuzzles.codefights.IsSubtree.Tree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(Parameterized.class)
public class IsSubtreeTest {
    private final Tree<Integer> t1;
    private final Tree<Integer> t2;
    private final boolean expected;

    public IsSubtreeTest(Tree<Integer> t1, Tree<Integer> t2, boolean expected) {
        this.t1 = t1;
        this.t2 = t2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new Tree<>(5,
                                new Tree<>(10,
                                        new Tree<>(4,
                                                new Tree<>(1),
                                                new Tree<>(2)),
                                        new Tree<>(6,
                                                null,
                                                new Tree<>(-1))),
                                new Tree<>(7)),
                        new Tree<>(10,
                                new Tree<>(4,
                                        new Tree<>(1),
                                        new Tree<>(2)),
                                new Tree<>(6,
                                        null,
                                        new Tree<>(-1))),
                        true
                },
                {
                        new Tree<>(5,
                                new Tree<>(10,
                                        new Tree<>(4,
                                                new Tree<>(1),
                                                new Tree<>(2)),
                                        new Tree<>(6,
                                                new Tree<>(-1),
                                                null)),
                                new Tree<>(7)),
                        new Tree<>(10,
                                new Tree<>(4,
                                        new Tree<>(1),
                                        new Tree<>(2)),
                                new Tree<>(6,
                                        null,
                                        new Tree<>(-1))),
                        false
                }
        });
    }

    @Test
    public void isSubtree() {
        boolean actual = IsSubtree.isSubtree(t1, t2);
        assertThat(actual, is(equalTo(expected)));
    }
}