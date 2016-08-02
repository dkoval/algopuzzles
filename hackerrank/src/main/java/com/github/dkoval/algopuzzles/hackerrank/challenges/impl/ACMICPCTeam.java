package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import java.util.Objects;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/acm-icpc-team">Problem:</a>
 * Max Score: 25 Difficulty: Easy
 */
public class ACMICPCTeam {

    static class Answer {
        /**
         * The maximum number of topics a 2-person team can know.
         */
        final int maxNumOfTopics;

        /**
         * The number of 2-person teams that can know the maximum number of topics.
         */
        final int numOfTeams;

        Answer(int maxNumOfTopics, int numOfTeams) {
            this.maxNumOfTopics = maxNumOfTopics;
            this.numOfTeams = numOfTeams;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Answer that = (Answer) obj;
            return maxNumOfTopics == that.maxNumOfTopics
                    && numOfTeams == that.numOfTeams;
        }

        @Override
        public int hashCode() {
            return Objects.hash(maxNumOfTopics, numOfTeams);
        }

        @Override
        public String toString() {
            return "Answer{" +
                    "maxNumOfTopics=" + maxNumOfTopics +
                    ", numOfTeams=" + numOfTeams +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Answer answer = solve(in);
        System.out.println(answer.maxNumOfTopics);
        System.out.println(answer.numOfTeams);
    }

    static Answer solve(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        String[] masks = new String[n];
        for (int i = 0; i < n; i++) {
            masks[i] = in.nextLine();
        }
        return doSolve(masks, m);
    }

    private static Answer doSolve(String[] masks, int m) {
        int maxNumOfTopics = 0, numOfTeams = 0;
        for (int i = 0; i < masks.length - 1; i++) {
            for (int j = i + 1; j < masks.length; j++) {
                int curNumOfTopics = numOfTopics(masks[i], masks[j], m);
                if (curNumOfTopics > maxNumOfTopics) {
                    maxNumOfTopics = curNumOfTopics;
                    numOfTeams = 1;
                } else if (curNumOfTopics == maxNumOfTopics) {
                    numOfTeams++;
                }
            }
        }
        return new Answer(maxNumOfTopics, numOfTeams);
    }

    private static int numOfTopics(String firstMask, String secondMask, int m) {
        int numOfTopics = 0;
        for (int i = 0; i < m; i++) {
            char first = firstMask.charAt(i);
            char second = secondMask.charAt(i);
            if (first == '1' || second == '1') {
                numOfTopics++;
            }
        }
        return numOfTopics;
    }
}
