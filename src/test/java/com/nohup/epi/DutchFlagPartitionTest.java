package com.nohup.epi;

import com.nohup.epi.DutchFlagPartition.Color;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Tests {@link DutchFlagPartition} solution.
 */
@RunWith(Parameterized.class)
public class DutchFlagPartitionTest {
    private final List<Color> input;
    private final List<Color> output;

    public DutchFlagPartitionTest(List<Color> input, List<Color> output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return asList(new Object[][]{
                // [0]
                {
                    asList(Color.WHITE, Color.WHITE, Color.BLUE, Color.WHITE, Color.BLUE, Color.BLUE, Color.WHITE),
                    asList(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE)
                },
                // [1]
                {
                    asList(Color.RED, Color.RED, Color.BLUE, Color.RED, Color.BLUE),
                    asList(Color.RED, Color.RED, Color.RED, Color.BLUE, Color.BLUE)
                },
                // [2]
                {
                    asList(Color.BLUE, Color.RED, Color.RED, Color.WHITE, Color.RED),
                    asList(Color.RED, Color.RED, Color.RED, Color.WHITE, Color.BLUE)
                },
        });
    }

    @Test
    public void dutchFlagPartitionSolution() {
        DutchFlagPartition.solution(-1, input);
        assertEquals(output, input);
    }
}
