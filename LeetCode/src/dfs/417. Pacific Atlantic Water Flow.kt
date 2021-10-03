package pacificatlanticwaterflow

import java.util.*

class Solution {

    fun pacificAtlantic(matrix: Array<IntArray>?): List<IntArray>? {
        val res: MutableList<IntArray> = LinkedList()
        if (matrix == null || matrix.isEmpty() || matrix[0].isEmpty()) {
            return res
        }
        val n = matrix.size
        val m: Int = matrix[0].size
        val pacific = Array(n) { BooleanArray(m) }
        val atlantic = Array(n) { BooleanArray(m) }
        for (i in 0 until n) {
            dfs(matrix, pacific, Int.MIN_VALUE, i, 0)
            dfs(matrix, atlantic, Int.MIN_VALUE, i, m - 1)
        }
        for (i in 0 until m) {
            dfs(matrix, pacific, Int.MIN_VALUE, 0, i)
            dfs(matrix, atlantic, Int.MIN_VALUE, n - 1, i)
        }
        for (i in 0 until n) for (j in 0 until m) if (pacific[i][j] && atlantic[i][j]) res.add(intArrayOf(i, j))
        return res
    }

    var dir = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

    private fun dfs(matrix: Array<IntArray>, visited: Array<BooleanArray>, height: Int, x: Int, y: Int) {
        val n = matrix.size
        val m: Int = matrix[0].size
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height) return
        visited[x][y] = true
        for (d in dir) {
            dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1])
        }
    }
}

