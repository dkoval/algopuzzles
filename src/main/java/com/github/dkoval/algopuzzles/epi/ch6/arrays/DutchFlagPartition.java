package com.github.dkoval.algopuzzles.epi.ch6.arrays;

import java.util.List;

/**
 * <a href="http://judge.elementsofprogramminginterviews.com:8080/post/dnf">Problem:</a>
 * <p>
 * Write a program that takes an array A and an index i into A, and rearranges the elements such that
 * all elements less than A[i] (the "pivot") appear first, followed by elements equal to the pivot,
 * followed by elements greater than the pivot.
 * </p>
 */
public class DutchFlagPartition {

    public enum Color {
        /* ordinal value: 0 */
        RED,
        /* ordinal value: 1 */
        WHITE,
        /* ordinal value: 2 */
        BLUE}

    // NB: the problem is solved in such a way that the `pivotIndex` argument is not being used at all.
    public static void solution(int pivotIndex, List<Color> A) {
        // The algorithm 3 indices r, w, b, maintaining the invariant r <= w <= b.
        // These 3 indices maintain 4 regions in the list:
        // - A[0..r-1] region contains RED elements;
        // - A[r, w-1] region contains WHITE elements;
        // - A[w, b] region contains unknown elements, that we have to rearrange;
        // - A[b+1, n-1] region contains BLUE elements.
        int r = 0, w = 0, b = A.size() - 1;

        // Every time we check the color of a new (unknown) element, pointed by index w,
        // we put the element in the right region, thus expanding its known region and
        // shrinking the unknown region.
        while (w <= b) {
            if (A.get(w) == Color.RED) {
                swap(A, r, w);
                r++;
                w++;
            } else if (A.get(w) == Color.BLUE) {
                swap(A, w, b);
                b--;
            } else {
                w++;
            }
        }
    }

    private static void swap(List<Color> A, int i, int j) {
        Color tmp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, tmp);
    }
}
