package besttimetobuyandsellstock

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var curPrice = prices[0]

        for(i in 1..prices.lastIndex) {
            val price = prices[i]
            if(price >= curPrice) {
                val profit = price - curPrice
                if(maxProfit < profit)
                    maxProfit = profit
            } else {
                curPrice = price
            }
        }

        return maxProfit
    }
}

