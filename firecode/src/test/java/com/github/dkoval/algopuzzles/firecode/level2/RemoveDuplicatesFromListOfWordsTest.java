package com.github.dkoval.algopuzzles.firecode.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests {@link RemoveDuplicatesFromListOfWords} solution.
 */
@RunWith(Parameterized.class)
public class RemoveDuplicatesFromListOfWordsTest {
    private final List<String> input;
    private final List<String> expected;

    public RemoveDuplicatesFromListOfWordsTest(List<String> input, List<String> expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList("Hello", "Hi", "Hey", "Hello", "Hi", "Hey"), Arrays.asList("Hello", "Hey", "Hi")},
                {Arrays.asList("Red", "Yellow", "Red", "Red", "Yellow"), Arrays.asList("Red", "Yellow")},
        });
    }

    @Test
    public void removeDuplicates() throws Exception {
        List<String> actual = RemoveDuplicatesFromListOfWords.removeDuplicates(input);
        assertThat(actual, is(expected));
    }
}
