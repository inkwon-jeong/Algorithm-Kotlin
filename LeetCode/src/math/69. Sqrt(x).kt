package sqrtx

class Solution {
    fun mySqrt(x: Int): Int {
        var left = 1
        var right = x

        while (left <= right) {
            val mid = left + (right - left) / 2
            val sqrt = x / mid
            when {
                sqrt < mid -> right = mid - 1
                sqrt > mid -> left = mid + 1
                else -> return sqrt
            }
        }

        return right
    }
}

