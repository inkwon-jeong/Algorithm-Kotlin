package numberofislands

import java.util.*

class Solution {

    private val dx = intArrayOf(1, 0, -1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)

    private lateinit var visited: Array<BooleanArray>
    private var m = 0
    private var n = 0

    fun numIslands(grid: Array<CharArray>): Int {
        m = grid.size
        n = grid.first().size
        visited = Array(m) { BooleanArray(n) }

        var num = 0

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    num++
                    visited[i][j] = true
                    queue.offer(i to j)

                    while (queue.isNotEmpty()) {
                        val (x, y) = queue.poll()
                        for (k in 0 until 4) {
                            val nx = x + dx[k]
                            val ny = y + dy[k]

                            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue
                            if (grid[nx][ny] == '1' && !visited[nx][ny]) {
                                visited[nx][ny] = true
                                queue.offer(nx to ny)
                            }
                        }
                    }
                }
            }
        }

        return num
    }
}

