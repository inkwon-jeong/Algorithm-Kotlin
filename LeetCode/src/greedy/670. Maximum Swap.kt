package maximumswap

class Solution {
    fun maximumSwap(num: Int): Int {
        val digits = num.toString().toCharArray()

        val buckets = IntArray(10)
        for (i in digits.indices) {
            buckets[digits[i] - '0'] = i
        }

        for (i in digits.indices) {
            for (k in 9 downTo digits[i] - '0' + 1) {
                if (buckets[k] > i) {
                    val tmp = digits[i]
                    digits[i] = digits[buckets[k]]
                    digits[buckets[k]] = tmp
                    return Integer.valueOf(String(digits))
                }
            }
        }

        return num
    }
}

