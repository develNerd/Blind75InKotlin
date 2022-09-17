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

fun main(){
    println(maxProfit2(intArrayOf(6,0,-1,1,10)))
}

fun maxProfit(prices: IntArray): Int {
    /**
    * We set the max profit as zero -> (Taking care of the edge case for returning 0)
    * */
    var maxprofit = 0

    for (i in 0 until prices.size - 1) {
        /**
         * We start the inner loop from an index i+1 since the buying price has to be of a lower index
         *d
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






/**
Taking this array - [7, 1, 5, 3, 6, 4]
* Let's look at a better solution with O(n) time complexity
* If we plot the numbers of the given array on a graph, we get:

if we plot the solution on a graph we buy at the lowest point on the graph and sell at
the highest point

          |
          |
          |
          -> 7        *
          |
          -> 6                                            *
          |
          -> 5                            *
  Prices  |
          -> 4
          |
          -> 3                                    *
          |
          -> 2
          |
          -> 1                   *
          |__     __   1   __    2  __    3  __   4   __   5   __   6   __
                                          Days

 From the graph we buy at day 2 (the most minimum point on the graph) and sell on day 5 (th highest point on the graph after we buy -- reference the main question)
*/


fun maxProfit2(prices: IntArray): Int {
    /**
     *  [7, 1, 5, 3, 6, 4]
     * We first assign the minprice a very large value
     * */
    var minprice = Int.MAX_VALUE // very large value
    var maxprofit = 0
    for (i in prices.indices) {
        /**
         * At this point we check if the current price[i] is less than the min price
         * to keep track of the lowest value on the graph as we go......
         * */
        if (prices[i] < minprice)
        {
            minprice = prices[i] // | 7 || 1 |||  1 |||| 1
        }
        /**
         * We then keep track of the largest value on the graph in the same loop
         * to keep track of the maximum profit that could be attained on the graph above
         * as we proceed
         *
         *
         * */
        else if (prices[i] - minprice > maxprofit)
        {
            maxprofit = prices[i] - minprice // ||| 4 |||| 4 ||||| 5
        }
    }
    return maxprofit
}

/**
 * Conclusion : The algorithm has a time complexity of O(n) and a space
 * complexity of O(1), since the number of variables does not grow with
 * corresponding array size
 *
 * */