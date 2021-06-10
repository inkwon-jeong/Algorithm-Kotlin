package besttimetobuyandsellstock2

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var price = prices[0]

        for(i in 1..prices.lastIndex) {
            if(price < prices[i]) {
                profit += (prices[i] - price)
            }
            price = prices[i]
        }
        return profit
    }
}