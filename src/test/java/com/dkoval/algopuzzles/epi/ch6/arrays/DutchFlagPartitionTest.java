package com.dkoval.algopuzzles.epi.ch6.arrays;

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
    private final List<DutchFlagPartition.Color> input;
    private final List<DutchFlagPartition.Color> output;

    public DutchFlagPartitionTest(List<DutchFlagPartition.Color> input, List<DutchFlagPartition.Color> output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return asList(new Object[][]{
                // [0]
                {
                    asList(DutchFlagPartition.Color.WHITE, DutchFlagPartition.Color.WHITE, DutchFlagPartition.Color.BLUE, DutchFlagPartition.Color.WHITE, DutchFlagPartition.Color.BLUE, DutchFlagPartition.Color.BLUE, DutchFlagPartition.Color.WHITE),
                    asList(DutchFlagPartition.Color.WHITE, DutchFlagPartition.Color.WHITE, DutchFlagPartition.Color.WHITE, DutchFlagPartition.Color.WHITE, DutchFlagPartition.Color.BLUE, DutchFlagPartition.Color.BLUE, DutchFlagPartition.Color.BLUE)
                },
                // [1]
                {
                    asList(DutchFlagPartition.Color.RED, DutchFlagPartition.Color.RED, DutchFlagPartition.Color.BLUE, DutchFlagPartition.Color.RED, DutchFlagPartition.Color.BLUE),
                    asList(DutchFlagPartition.Color.RED, DutchFlagPartition.Color.RED, DutchFlagPartition.Color.RED, DutchFlagPartition.Color.BLUE, DutchFlagPartition.Color.BLUE)
                },
                // [2]
                {
                    asList(DutchFlagPartition.Color.BLUE, DutchFlagPartition.Color.RED, DutchFlagPartition.Color.RED, DutchFlagPartition.Color.WHITE, DutchFlagPartition.Color.RED),
                    asList(DutchFlagPartition.Color.RED, DutchFlagPartition.Color.RED, DutchFlagPartition.Color.RED, DutchFlagPartition.Color.WHITE, DutchFlagPartition.Color.BLUE)
                },
        });
    }

    @Test
    public void dutchFlagPartitionSolution() {
        DutchFlagPartition.solution(-1, input);
        assertEquals(output, input);
    }
}
