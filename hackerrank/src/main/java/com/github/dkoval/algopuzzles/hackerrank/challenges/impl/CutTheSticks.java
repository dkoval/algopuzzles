package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import java.util.*;

/**
 * <a href="https://www.hackerrank.com/challenges/cut-the-sticks">Problem:</a>
 * Max Score: 25 Difficulty: Easy
 */
public class CutTheSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> sticks = new LinkedList<>();
        while (n > 0) {
            sticks.add(in.nextInt());
            n--;
        }
        List<Integer> answer = solve(sticks);
        answer.forEach(System.out::println);
    }

    static List<Integer> solve(List<Integer> sticks) {
        List<Integer> answer = new LinkedList<>();
        while (!sticks.isEmpty()) {
            answer.add(sticks.size());
            Integer min = Collections.min(sticks);
            ListIterator<Integer> it = sticks.listIterator();
            while (it.hasNext()) {
                int upd = it.next() - min;
                if (upd != 0) {
                    it.set(upd);
                } else {
                    it.remove();
                }
            }
        }
        return answer;
    }
}
