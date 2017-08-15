package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-comparator-sorting">Sorting: Comparator</a>
 * Max Score: 35 Difficulty: Medium
 */
public class Comparator {

    static class Player {
        final String name;
        final int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Player player = (Player) obj;
            return score == player.score &&
                    Objects.equals(name, player.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, score);
        }
    }

    static class Checker implements java.util.Comparator<Player> {

        @Override
        public int compare(Player a, Player b) {
            if (a.score == b.score) {
                return a.name.compareTo(b.name);
            }
            return -1 * Integer.compare(a.score, b.score);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] players = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            players[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(players, checker);
        for (Player player : players) {
            System.out.printf("%s %s\n", player.name, player.score);
        }
    }
}
