package com.github.dkoval.algopuzzles.hackerrank.contests.weekOfCode21;

import java.util.*;

/**
 * <a href="https://www.hackerrank.com/contests/w21/challenges/luck-balance">Problem:</a>
 * Max Score: 20 Difficulty: Easy
 */
public class LuckBalance {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        List<Integer> important = new ArrayList<>();
        List<Integer> unimportant = new ArrayList<>();
        while (n > 0) {
            int li = in.nextInt();
            int ti = in.nextInt();
            if (ti == 1) {
                important.add(li);
            } else {
                unimportant.add(li);
            }
            n--;
        }

        Collections.sort(important);
        int importantWins = 0;
        int numOfImportantWins = k < important.size() ? important.size() - k : 0;
        Iterator<Integer> it = important.iterator();
        while (numOfImportantWins > 0) {
            importantWins += it.next();
            it.remove();
            numOfImportantWins--;
        }

        int answer = important.stream().reduce(0, Integer::sum)
                + unimportant.stream().reduce(0, Integer::sum)
                - importantWins;
        System.out.println(answer);
    }
}
