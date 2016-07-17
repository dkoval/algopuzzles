package com.github.dkoval.algopuzzles.hackerrank.contests.worldCodesprintApril;

import java.util.*;

/**
 * <a href="https://www.hackerrank.com/contests/world-codesprint-april/challenges/gena">Problem:</a>
 * Max Score: 40 Difficulty: Moderate
 * <p>
 * The Tower of Hanoi is a famous game consisting of 3 rods and a number of discs of incrementally different diameters.
 * The puzzle starts with the discs neatly stacked on one rod, ordered by ascending size with the smallest disc at the top.
 * The game's objective is to move the entire stack to another rod, obeying the following rules:
 * <ol>
 * <li>Only one disc can be moved at a time.</li>
 * <li>Each move consists of taking the topmost disc from a stack and moving it to the top of another stack.</li>
 * <li>No disc may be placed on top of a smaller disc.</li>
 * </ol>
 * Gena has a modified version of the Tower of Hanoi. His Hanoi has 4 rods and N discs ordered by ascending size.
 * He made a few moves (following the rules above), but stopped and lost his place. He wants to restore the tower
 * to its original state by making valid moves. Given the state of Gena's Hanoi, help him calculate the minimum
 * number of moves needed to restore the tower to its original state.
 * <p>
 * Note: Gena's rods are numbered from 1 to 4. All discs are initially located on rod 1.
 * <p>
 * Input Format
 * <p>
 * The first line contains a single integer, N, denoting the number of discs.
 * The second line contains N space-separated integers, where the i-th integer is the index of the rod
 * where the disk with diameter i is located.
 * <p>
 * Constraints
 * <ul>
 * <li>1<=N<=10</li>
 * </ul>
 * Output Format
 * <p>
 * Print the minimum number of moves Gena must make to restore the tower to its initial, ordered state on the first rod.
 */
public class GenaPlayingHanoi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] stateOfHanoi = new int[n];
        for (int i = 0; i < n; i++) {
            // index 4 rods starting from zero: 0, 1, 2, 3
            stateOfHanoi[i] = in.nextInt() - 1;
        }
        int answer = solve(stateOfHanoi);
        System.out.println(answer);
    }

    static int solve(int[] stateOfHanoi) {
        int n = stateOfHanoi.length;
        int h = stateOfHanoiHash(stateOfHanoi);

        // Initial state of Tower of Hanoi game: all n disks reside on rod #0.
        // Note that stateOfHanoiHash({0, 0, ..., 0}) = 0, therefore we do not calculate the hash
        // for the initial state of Hanoi game.
        // There are possible 4^N states of the game in total.
        Map<Integer, Integer> moves = new HashMap<>();
        moves.put(0, 0);

        // bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int x = q.poll();
            // check if the target state of the game is reached
            int numOfMoves = moves.get(x);
            if (x == h) {
                return numOfMoves;
            }
            // take 4 topmost discs (discs are ordered by ascending size)
            // go through all the discs to handle 2 corner cases:
            // 1. - all of the discs are placed on the same rod,
            // 2. - some of the rods are not occupied at all
            int[] topmostDiscs = new int[4];
            // Integer.MAX_VALUE denotes an empty rod here, i.e. disc of any size can be placed on it
            Arrays.fill(topmostDiscs, Integer.MAX_VALUE);
            // go through the entire array to make sure the smallest discs are picked up
            for (int i = n - 1; i >= 0; i--) {
                int rod = (x >> i * 2) & 0b11;
                topmostDiscs[rod] = i;
            }
            // generate all the possible moves, taking into account the fact
            // that no disc may be placed on top of a smaller disc
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((i != j) && (topmostDiscs[i] < topmostDiscs[j])) {
                        // can take the topmost disc from rod j and move it to the top of rod i
                        int mask = 0b11 << topmostDiscs[i] * 2;
                        int targetRod = j << topmostDiscs[i] * 2;
                        // following updates the stateOfHanoi[] array represented by the hash x
                        int y = (x & ~mask) | targetRod;
                        if (!moves.containsKey(y)) {
                            moves.put(y, numOfMoves + 1);
                            q.add(y);
                        }
                    }
                }
            }
        }
        throw new IllegalStateException("Unexpected algorithm termination");
    }

    private static int stateOfHanoiHash(int[] stateOfHanoi) {
        // Each rod number stateOfHanoi[i] is either 0, 1, 2 or 3,
        // meaning that the decimal value can be easily represented by 2 bits,
        // indeed 0 - 0b00, 1 - 0b01, 2 - 0b10, 3 - 0b11.
        // Now, the problem states N <= 10, so we need maximum 20 bits in order to
        // represent the entire stateOfHanoi[] array as an integer.
        // On the other hand, Java int type is 4 bytes = 32 bits, which is good enough
        // for the  purpose of this task.
        // Alternatively, we could have represented stateOfHanoi[] array as an integer base 4 or 10.
        int hash = 0;
        for (int i = 0; i < stateOfHanoi.length; i++) {
            hash |= stateOfHanoi[i] << i * 2;
        }
        return hash;
    }
}
