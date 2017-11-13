package com.github.dkoval.algopuzzles.hackerrank.contests.w35;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link LuckyPurchase} solution.
 */
@RunWith(Parameterized.class)
public class LuckyPurchaseTest {
    private final Map<String, Integer> laptopPrices;
    private final String answer;

    public LuckyPurchaseTest(Map<String, Integer> laptopPrices, String answer) {
        this.laptopPrices = laptopPrices;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new LinkedHashMap<String, Integer>() {{
                            put("HackerBook", 777444);
                            put("RankBook", 3);
                            put("TheBook", 777);
                            put("BestBook", 47);
                        }},
                        "BestBook"
                },
                {
                        new LinkedHashMap<String, Integer>() {{
                            put("abacab", 121);
                        }},
                        "-1"
                },
        });
    }

    @Test
    public void solution() throws Exception {
        String myAnswer = LuckyPurchase.solution(laptopPrices);
        assertEquals(answer, myAnswer);
    }
}