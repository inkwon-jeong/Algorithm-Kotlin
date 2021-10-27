package beautifularrangement

class Solution {
    var count = 0
    fun countArrangement(n: Int): Int {
        if (n == 0) return 0;
        helper(n, 1, IntArray(n + 1))
        return count
    }

    private fun helper(n: Int, pos: Int, used: IntArray) {
        if (pos > n) {
            count++
            return
        }
        for (i in 1..n) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1
                helper(n, pos + 1, used)
                used[i] = 0
            }
        }
    }
}

