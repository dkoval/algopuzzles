package com.github.dkoval.algopuzzles.hackerrank.contests.w35;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/w35/challenges/lucky-purchase">Lucky Purchase</a>
 * Max Score: 10 Difficulty: Easy
 */
public class LuckyPurchase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> prices = new LinkedHashMap<>();
        for (int a0 = 0; a0 < n; a0++) {
            String name = in.next();
            int value = in.nextInt();
            prices.put(name, value);
        }
        String answer = solution(prices);
        System.out.println(answer);
        in.close();
    }

    static String solution(Map<String, Integer> laptopPrices) {
        String candidateBrand = "-1";
        int candidatePrice = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> laptop : laptopPrices.entrySet()) {
            String brand = laptop.getKey();
            Integer price = laptop.getValue();
            if (isAcceptablePrice(price) && (price < candidatePrice)) {
                candidateBrand = brand;
                candidatePrice = price;
            }
        }
        return candidateBrand;
    }

    private static boolean isAcceptablePrice(int price) {
        int num4s = 0;
        int num7s = 0;
        while (price != 0) {
            int digit = price % 10;
            if (digit == 4) {
                num4s++;
            }
            if (digit == 7) {
                num7s++;
            }
            if (digit < 4 || digit > 7) {
                return false;
            }
            price /= 10;
        }
        return (num4s != 0) && (num7s != 0) && (num4s == num7s);
    }
}
