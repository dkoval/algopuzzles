package com.github.dkoval.algopuzzles.firecode.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * A Range Module is a module that tracks ranges of numbers. Range modules are used extensively when designing
 * scalable online game maps with millions of players. Your task is to write a method - mergeIntervals
 * that takes in an ArrayList of integer Interval s (aka ranges), and returns an ArrayList of sorted Intervals
 * where all overlapping intervals have been merged.
 * <pre>
 * Examples:
 * Input: [ [1,3], [2,5] ], Output: [ [1,5] ]
 * Input: [ [3,5], [1,2] ], Output: [ [1,2], [3,5] ]
 * </pre>
 */
public class RangeModule {

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Interval that = (Interval) obj;
            return start == that.start && end == that.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        Collections.sort(input, (i1, i2) -> Integer.compare(i1.start, i2.start));
        ArrayList<Interval> output = new ArrayList<>();
        Interval prev = input.get(0);

        for (int i = 1; i < input.size(); i++) {
            Interval next = input.get(i);
            if (next.start <= prev.end) {
                // there is an overlap
                prev = new Interval(prev.start, Math.max(prev.end, next.end));
            } else {
                output.add(prev);
                prev = next;
            }
        }
        output.add(prev);
        return output;
    }
}
