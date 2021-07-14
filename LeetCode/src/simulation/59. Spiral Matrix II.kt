package spiralmatrix2

class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        val matrix = Array(n) { IntArray(n) }
        val directions = arrayOf(
            0 to 1,
            1 to 0,
            0 to -1,
            -1 to 0
        )

        var num = 1
        var direction = 0
        var x = 0
        var y = 0

        while (matrix[x][y] == 0) {
            matrix[x][y] = num++
            val (nx, ny) = directions[direction]
            var dx = x + nx
            var dy = y + ny
            if (dx < 0 || dx >= n || dy < 0 || dy >= n || matrix[dx][dy] != 0) {
                direction = (direction + 1) % 4
                val (mx, my) = directions[direction]
                dx = x + mx
                dy = y + my
            }

            x = dx
            y = dy

            if (x < 0 || x >= n || y < 0 || y >= n)
                break
        }

        return matrix
    }
}

