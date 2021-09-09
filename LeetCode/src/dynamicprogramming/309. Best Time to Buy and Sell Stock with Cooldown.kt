package besttimetobuyandsellstockwithcooldown

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2)
            return 0

        val stock = IntArray(prices.size)
        val profit = IntArray(prices.size)

        stock[0] = -prices[0]
        stock[1] = -min(prices[0], prices[1])
        profit[1] = max(0, stock[0] + prices[1])

        for (i in 2 until prices.size) {
            stock[i] = max(stock[i - 1], profit[i - 2] - prices[i])
            profit[i] = max(profit[i - 1], stock[i - 1] + prices[i])
        }

        return profit[prices.lastIndex]
    }
}