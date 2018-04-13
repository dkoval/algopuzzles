package com.github.dkoval.algopuzzles.hackerearth.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class RegistrationSystemTest {
    private final List<String> input;
    private final List<String> output;

    public RegistrationSystemTest(List<String> input, List<String> output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        Arrays.asList(
                                "lebron",
                                "lebron0",
                                "lebron1",
                                "lebron"),
                        Arrays.asList(
                                "lebron",
                                "lebron0",
                                "lebron1",
                                "lebron2"
                        )
                },
                {
                        Arrays.asList(
                                "pe8150",
                                "pe8152",
                                "pe8150",
                                "pe8151",
                                "pe8150",
                                "pe8152",
                                "pe815",
                                "pe815",
                                "pe8150",
                                "pe8153"),
                        Arrays.asList(
                                "pe8150",
                                "pe8152",
                                "pe81500",
                                "pe8151",
                                "pe81501",
                                "pe81520",
                                "pe815",
                                "pe8153",
                                "pe81502",
                                "pe81530"
                        )
                },
        });
    }

    @Test
    public void registration() {
        RegistrationSystem db = new RegistrationSystem();
        List<String> actual = input.stream().map(db::register).collect(toList());
        assertThat(actual, equalTo(output));
    }
}
