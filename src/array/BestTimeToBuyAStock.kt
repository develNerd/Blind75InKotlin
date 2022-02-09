package array

/**
*
* You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
*
*
* */


/**
* Solution 1 : Brute Force
*
 * With this approach the Time complexity is O(n2) and space complexity of O(1), we will implement a much better approach in the next solution
*  Taking each of the numbers we iterate through and compare with each of the other numbers in the array with increasing index
 *  since to calculate for the profit we need the buying price to be of a lower index that the selling price.
 *  so outer loop with starts with an index of (i) and inner loop (i + 1) .
 * Buy on day 2(price = 1) and sell on day 5 (price = 6) maxProfit = 6-1 = 5
* */

fun maxProfit(prices: IntArray): Int {
    /**
    * We set the max profit as zero -> (Taking care of the edge case for returning 0)
    * */
    var maxprofit = 0

    for (i in 0 until prices.size - 1) {
        /**
         * We start the inner loop from an index i+1 since the buying price has to be of a lower index
         *
         * */
        for (j in i + 1 until prices.size) {
            /**
             * Calculate the profit by substracting the buying price from the selling price
             * and set the currentMaxProfit if it is greater
             * */
            val profit = prices[j] - prices[i]
            if (profit > maxprofit) maxprofit = profit
        }
    }
    return maxprofit
}