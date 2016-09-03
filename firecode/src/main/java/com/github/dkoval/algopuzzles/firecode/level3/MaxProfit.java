package com.github.dkoval.algopuzzles.firecode.level3;

/**
 * You've recently acquired market prediction superpowers that let you predict the closing stock price of a Acme Inc.'s
 * stock a month into the future! To get the most out of this superpower, you need to write a method called maxProfit
 * that takes in an array of integers representing the close out stock price on a given day. This method should return
 * the maximum profit you can make out of trading Acme Inc.'s stock. There are a few limitations however:
 * <p>
 * 1) You must sell your current holding before buying another - i.e. You may not buy and then buy again.
 * It needs to be a buy - sell - buy - sell ... pattern.
 * <p>
 * 2) You may complete as many transactions as you like. You're using an awesome service like Robinhood, and so
 * there are no transaction costs!
 * <p>
 * 3) If you're enormously unlucky (or karma takes over) and no profit can be made, return 0.
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                maxProfit += diff;
            }
        }
        return (maxProfit > 0) ? maxProfit : 0;
    }
}
