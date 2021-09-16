package integerbreak

class Solution {
    fun integerBreak(n: Int): Int {
        var num = n
        if (num == 2) return 1
        if (num == 3) return 2
        var product = 1
        while (num > 4) {
            product *= 3
            num -= 3
        }
        product *= num

        return product
    }
}

