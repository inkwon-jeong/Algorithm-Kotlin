package spiralmatrix

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val m = matrix[0].size
        val n = matrix.size

        val visited = Array(n) { BooleanArray(m) }
        val directions = arrayOf(
            0 to 1,
            1 to 0,
            0 to -1,
            -1 to 0
        )

        val answer = mutableListOf<Int>()
        var direction = 0
        var x = 0
        var y = 0

        while (!visited[x][y]) {
            visited[x][y] = true
            answer.add(matrix[x][y])
            val (nx, ny) = directions[direction]
            var dx = x + nx
            var dy = y + ny
            if (dx < 0 || dx >= n || dy < 0 || dy >= m || visited[dx][dy]) {
                direction = (direction + 1) % 4
                val (mx, my) = directions[direction]
                dx = x + mx
                dy = y + my
            }

            x = dx
            y = dy

            if (x < 0 || x >= n || y < 0 || y >= m)
                break
        }

        return answer
    }
}

