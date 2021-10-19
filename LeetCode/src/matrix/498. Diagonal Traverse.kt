package diagonaltraverse

class Solution {
    fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
        if (matrix.isEmpty()) return intArrayOf()
        var r = 0
        var c = 0
        val m = matrix.size
        val n = matrix[0].size
        val arr = IntArray(m * n)
        for (i in arr.indices) {
            arr[i] = matrix[r][c]
            if ((r + c) % 2 == 0) { // moving up
                if (c == n - 1) {
                    r++
                } else if (r == 0) {
                    c++
                } else {
                    r--
                    c++
                }
            } else {
                if (r == m - 1) {
                    c++
                } else if (c == 0) {
                    r++
                } else {
                    r++
                    c--
                }
            }
        }
        return arr
    }
}