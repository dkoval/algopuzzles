package com.github.dkoval.algopuzzles.codefights;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * <a href="https://codefights.com/interview-practice/task/xrFgR63cw7Nch4vXo">groupingDishes</a>
 * You have a list of dishes. Each dish is associated with a list of ingredients used to prepare it.
 * You want to group the dishes by ingredients, so that for each ingredient you'll be able to find all the dishes
 * that contain it (if there are at least 2 such dishes).
 * <p/>
 * Return an array where each element is a list with the first element equal to the name of the ingredient
 * and all of the other elements equal to the names of dishes that contain this ingredient.
 * The dishes inside each list should be sorted lexicographically.
 * The result array should be sorted lexicographically by the names of the ingredients in its elements.
 */
public class GroupingDishes {

    static String[][] groupingDishes(String[][] dishes) {
        Map<String, Set<String>> map = new TreeMap<>();
        for (String[] dishWithIngredients : dishes) {
            String dish = dishWithIngredients[0];
            for (int i = 1; i < dishWithIngredients.length; i++) {
                String ingredient = dishWithIngredients[i];
                map.computeIfAbsent(ingredient, k -> new TreeSet<>()).add(dish);
            }
        }
        return map.entrySet().stream()
                .filter(entry -> entry.getValue().size() >= 2)
                .map(entry -> {
                    String ingredient = entry.getKey();
                    Set<String> dishesWithThisIngredient = entry.getValue();
                    return Stream.concat(Stream.of(ingredient), dishesWithThisIngredient.stream()).toArray(String[]::new);
                })
                .toArray(String[][]::new);
    }
}
