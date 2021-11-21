package beatifularrangement2

class Solution {
    fun constructArray(n: Int, k: Int): IntArray {
        val res = IntArray(n)
        for (i in 0 until n) res[i] = i + 1
        for (i in 1 until k) reverseList(res, i, n - 1)
        return res
    }

    private fun reverseList(res: IntArray, start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            val temp = res[left]
            res[left] = res[right]
            res[right] = temp
            left++
            right--
        }
    }
}

