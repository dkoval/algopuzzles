package com.github.dkoval.algopuzzles.firecode.level3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * Tests {@link PrintPaths} solution.
 */
@RunWith(Parameterized.class)
public class PrintPathsTest {
    private final char[][] board;
    private final String[] expected;

    public PrintPathsTest(char[][] board, String[] expected) {
        this.board = board;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new char[0][0], new String[0]},
                {new char[][]{
                        {'A'}
                }, new String[]{"A"}},
                {new char[][]{
                        {'A', 'B', 'C'}
                }, new String[]{"ABC"}},
                {new char[][]{
                        {'A', 'B'},
                        {'C', 'D'}
                }, new String[]{"ABD", "ACD"}},
                {new char[][]{
                        {'A', 'B', 'C', 'D'},
                        {'E', 'F', 'G', 'H'},
                        {'I', 'J', 'K', 'L'}
                }, new String[]{"ABCDHL", "ABCGHL", "ABCGKL", "ABFGHL", "ABFGKL", "ABFJKL", "AEFGHL", "AEFGKL", "AEFJKL", "AEIJKL"}},
                {new char[][]{
                        {'A'},
                        {'B'},
                        {'C'},
                        {'D'}
                }, new String[]{"ABCD"}},
                {new char[][]{
                        {'A', 'B', 'C', 'D'},
                        {'E', 'F', 'G', 'H'},
                        {'I', 'J', 'K', 'L'},
                        {'M', 'N', 'O', 'P'}
                }, new String[]{"ABCDHLP", "ABCGHLP", "ABCGKLP", "ABCGKOP", "ABFGHLP", "ABFGKLP", "ABFGKOP", "ABFJKLP",
                        "ABFJKOP", "ABFJNOP", "AEFGHLP", "AEFGKLP", "AEFGKOP", "AEFJKLP", "AEFJKOP", "AEFJNOP", "AEIJKLP",
                        "AEIJKOP", "AEIJNOP", "AEIMNOP"}},
        });
    }

    @Test
    public void printPaths() throws Exception {
        ArrayList<String> actual = PrintPaths.printPaths(board);
        assertThat(actual, containsInAnyOrder(expected));
    }
}
