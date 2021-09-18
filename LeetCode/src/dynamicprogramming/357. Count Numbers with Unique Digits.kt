package countnumberswithuniquedigits

class Solution {
    fun countNumbersWithUniqueDigits(n: Int): Int {
        var num = n
        if (num == 0) return 1

        var res = 10
        var uniqueDigits = 9
        var availableNumber = 9
        while (num-- > 1 && availableNumber > 0) {
            uniqueDigits *= availableNumber
            res += uniqueDigits
            availableNumber--
        }
        return res
    }
}

