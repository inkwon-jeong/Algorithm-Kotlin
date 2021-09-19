package sumoftwointegers

class Solution {
    fun getSum(a: Int, b: Int): Int {
        var sum = 0
        var carry = 0
        val bits = IntArray(32)
        var num1 = a
        var num2 = b

        repeat(32) { index ->
            val bit1 = num1 and 1
            val bit2 = num2 and 1
            when {
                bit1 == 0 && bit2 == 0 -> {
                    if (carry == 0)
                        bits[index] = 0
                    else {
                        bits[index] = 1
                    }
                    carry = 0
                }
                bit1 == 1 && bit2 == 1 -> {
                    if (carry == 0)
                        bits[index] = 0
                    else {
                        bits[index] = 1
                    }
                    carry = 1
                }
                else -> {
                    if (carry == 0)
                        bits[index] = 1
                    else {
                        bits[index] = 0
                        carry = 1
                    }
                }
            }
            num1 = num1 shr 1
            num2 = num2 shr 1
        }

        for (index in 31 downTo 0) {
            sum = (sum shl 1) or bits[index]
        }

        return sum
    }
}

