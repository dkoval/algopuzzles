package com.github.dkoval.algopuzzles.codefights;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class GroupingDishesTest {
    private final String[][] dishes;
    private final String[][] expected;

    public GroupingDishesTest(String[][] dishes, String[][] expected) {
        this.dishes = dishes;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new String[][]{
                                {"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                                {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
                                {"Quesadilla", "Chicken", "Cheese", "Sauce"},
                                {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"},
                        },
                        new String[][]{
                                {"Cheese", "Quesadilla", "Sandwich"},
                                {"Salad", "Salad", "Sandwich"},
                                {"Sauce", "Pizza", "Quesadilla", "Salad"},
                                {"Tomato", "Pizza", "Salad", "Sandwich"},
                        }
                },
                {
                        new String[][]{
                                {"Pasta", "Tomato Sauce", "Onions", "Garlic"},
                                {"Chicken Curry", "Chicken", "Curry Sauce"},
                                {"Fried Rice", "Rice", "Onions", "Nuts"},
                                {"Salad", "Spinach", "Nuts"},
                                {"Sandwich", "Cheese", "Bread"},
                                {"Quesadilla", "Chicken", "Cheese"}
                        },
                        new String[][]{
                                {"Cheese", "Quesadilla", "Sandwich"},
                                {"Chicken", "Chicken Curry", "Quesadilla"},
                                {"Nuts", "Fried Rice", "Salad"},
                                {"Onions", "Fried Rice", "Pasta"}
                        }
                }
        });
    }


    @Test
    public void groupingDishes() {
        String[][] actual = GroupingDishes.groupingDishes(dishes);
        assertArrayEquals(expected, actual);
    }
}