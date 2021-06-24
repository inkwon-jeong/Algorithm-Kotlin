package plusone

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var index = digits.lastIndex
        while (index >= 0) {
            val digit = digits[index]
            if(digit + 1 == 10) {
                digits[index--] = 0
            } else {
                digits[index] = digit + 1
                break
            }
        }

        return if(index == -1) {
            val answer = IntArray(digits.size + 1)
            answer[0] = 1
            digits.forEachIndexed { index, num ->
                answer[index + 1] = digits[index]
            }
            answer
        } else digits
    }
}

