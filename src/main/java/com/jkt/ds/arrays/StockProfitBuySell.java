package com.jkt.ds.arrays;

/**
 * Given an array of daily prizes of stock.
 *
 * A. Buy Sell once to maximize profit.
 *
 * B. Buy Sell multiple times to maximize profit.
 *
 * @author jaikit
 *
 */
public class StockProfitBuySell {

    public static void main(final String args[]) {

        final StockProfitBuySell stockProfitBuySell = new StockProfitBuySell();
        final int input[] = { 5, 6, 7, 1, 5, 1, 5 };

        System.out.println(stockProfitBuySell.buysellOnce(input));

        System.out.println(stockProfitBuySell.buysellMultiple(input));

    }

    private long buysellMultiple(final int[] input) {

        int profit = 0;

        int maxPrice = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        /* best example: 1, 10, 1, 10, 1, 10 */
        for (int i = 0; i < input.length; i++) {
            if (input[i] > maxPrice) {
                maxPrice = input[i];
            }
            if (input[i] < minPrice) {
                minPrice = input[i];

            }
            final int p = input[i] - minPrice;
            if (p > 0) {
                profit = profit + p;
                minPrice = maxPrice;
                maxPrice = Integer.MIN_VALUE;
            }
        }

        return profit;
    }

    private long buysellOnce(final int[] input) {
        long minStockPrice = Long.MAX_VALUE;
        long profit = Long.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            if (input[i] < minStockPrice) {
                minStockPrice = input[i];
            }
            if ((input[i] - minStockPrice) > profit) {
                profit = input[i] - minStockPrice;
            }

        }
        return profit;
    }
}
