package com.github.dkoval.algopuzzles.firecode.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a List of Strings, write a method removeDuplicates that removes duplicate words from the List
 * and returns an ArrayList of all the unique words.
 * The returned ArrayList should be lexically sorted.
 */
public class RemoveDuplicatesFromListOfWords {

    public static ArrayList<String> removeDuplicates(List<String> input) {
        Set<String> unique = new TreeSet<>(input);
        return new ArrayList<>(unique);
    }
}
