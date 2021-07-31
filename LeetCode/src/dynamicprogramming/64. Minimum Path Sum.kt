package minimumpathsum

import kotlin.math.min

class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid.first().size

        val minPathSums = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == 0 && j == 0) {
                    minPathSums[i][j] = grid[i][j]
                    continue
                }

                val up = minPathSums.getOrNull(i - 1)?.getOrNull(j) ?: Int.MAX_VALUE
                val left = minPathSums.getOrNull(i)?.getOrNull(j - 1) ?: Int.MAX_VALUE
                minPathSums[i][j] = grid[i][j] + min(up, left)
            }
        }

        return minPathSums[m - 1][n - 1]
    }
}