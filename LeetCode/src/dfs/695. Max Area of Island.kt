package maxareaofisland

class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea = 0
        for (i in grid.indices)
            for (j in 0 until grid[0].size)
                if (grid[i][j] == 1) maxArea =
                    maxArea.coerceAtLeast(areaOfIsland(grid, i, j))

        return maxArea
    }

    private fun areaOfIsland(grid: Array<IntArray>, i: Int, j: Int): Int {
        if (i >= 0 && i < grid.size && j >= 0 && j < grid[0].size && grid[i][j] == 1) {
            grid[i][j] = 0
            return 1 + areaOfIsland(grid, i + 1, j) +
                areaOfIsland(grid, i - 1, j) +
                areaOfIsland(grid, i, j - 1) +
                areaOfIsland(grid, i, j + 1)
        }
        return 0
    }
}

