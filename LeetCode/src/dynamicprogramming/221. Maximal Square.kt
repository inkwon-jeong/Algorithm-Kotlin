package maximalsquare

import kotlin.math.max
import kotlin.math.min

class Solution {

    private lateinit var d: Array<IntArray>
    private val dx = intArrayOf(1, 0, 1)
    private val dy = intArrayOf(0, 1, 1)
    private var m = 0
    private var n = 0

    fun maximalSquare(matrix: Array<CharArray>): Int {
        m = matrix.size
        n = matrix.first().size
        d = Array(m) { IntArray(n) { -1 } }

        var answer = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                answer = if (d[i][j] == -1) {
                    val square = maximalSquare(matrix, i, j)
                    max(answer, square)
                } else
                    max(answer, d[i][j])
            }
        }

        return answer * answer
    }

    private fun maximalSquare(matrix: Array<CharArray>, x: Int, y: Int): Int {
        if (matrix[x][y] == '0') {
            d[x][y] = 0
            return 0
        }

        if (d[x][y] != -1)
            return d[x][y]

        var min = Int.MAX_VALUE
        for (k in 0..2) {
            val nx = x + dx[k]
            val ny = y + dy[k]
            if (nx >= m || ny >= n) {
                min = 0
                break
            }

            min = min(min, maximalSquare(matrix, nx, ny))
        }

        d[x][y] = min + 1
        return d[x][y]
    }
}

