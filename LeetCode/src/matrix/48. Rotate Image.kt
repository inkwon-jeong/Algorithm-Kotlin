package rotateimage

class Solution {

    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        val visited = Array(n) { BooleanArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                rotate(matrix, i, j, matrix[i][j], visited)
            }
        }
    }

    private fun rotate(matrix: Array<IntArray>, x: Int, y: Int, value: Int, visited: Array<BooleanArray>) {
        if (visited[x][y])
            return

        visited[x][y] = true

        val n = matrix.size
        val nx = y
        val ny = (n - 1) - x
        val temp = matrix[nx][ny]
        matrix[nx][ny] = value

        rotate(matrix, nx, ny, temp, visited)
    }
}

