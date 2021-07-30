package uniquepaths2

class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid.first().size

        val grid = Array(m) { IntArray(n) { 0 } }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (obstacleGrid[i][j] == 1)
                    continue

                if (i == 0 && j == 0) {
                    grid[i][j] = 1
                    continue
                }

                val up = grid.getOrNull(i - 1)?.getOrNull(j) ?: 0
                val left = grid.getOrNull(i)?.getOrNull(j - 1) ?: 0
                grid[i][j] = up + left
            }
        }

        return grid[m - 1][n - 1]
    }
}

