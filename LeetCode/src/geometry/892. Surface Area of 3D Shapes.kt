package surfaceareaof3shapes

class Solution {
    fun surfaceArea(grid: Array<IntArray>): Int {
        val n = grid.lastIndex
        var totalSurfaces = 0

        for (i in 0..n) {
            for (j in 0..n) {
                val area = grid[i][j]

                if(area == 0)
                    continue

                val eastArea = grid.getOrNull(i)?.getOrNull(j + 1) ?: 0
                val westArea = grid.getOrNull(i)?.getOrNull(j - 1) ?: 0
                val northArea = grid.getOrNull(i - 1)?.getOrNull(j) ?: 0
                val southArea = grid.getOrNull(i + 1)?.getOrNull(j) ?: 0

                val eastSurface = if(area - eastArea > 0) area - eastArea else 0
                val westSurface = if(area - westArea > 0) area - westArea else 0
                val northSurface = if(area - northArea > 0) area - northArea else 0
                val southSurface = if(area - southArea > 0) area - southArea else 0

                val surface = 2 + eastSurface + westSurface + northSurface + southSurface
                totalSurfaces += surface
            }
        }

        return totalSurfaces
    }
}

