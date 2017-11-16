package com.github.dkoval.algopuzzles.hackerrank.contests.w35;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/w35/challenges/3d-surface-area">3D Surface Area</a>
 * Max Score: 30 Difficulty: Medium
 */
public class ThreeDSurfaceArea {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int w = in.nextInt();
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int result = surfaceArea(a);
        System.out.println(result);
        in.close();
    }

    static int surfaceArea(int[][] a) {
        int h = a.length;
        int w = a[0].length;
        int totalPrice = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int cellPrice = cellPrice(a[i][j]);
                totalPrice += cellPrice;
                if (j > 0) {
                    totalPrice -= 2 * Math.min(a[i][j - 1], a[i][j]);
                }
                if (i > 0) {
                    totalPrice -= 2 * Math.min(a[i - 1][j], a[i][j]);
                }
            }
        }
        return totalPrice;
    }

    private static int cellPrice(int numCubes) {
        return (numCubes > 1) ? 4 * numCubes + 2 : 6;
    }
}
