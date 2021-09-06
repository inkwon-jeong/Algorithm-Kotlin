package gameoflife

class Solution {

    val dx = intArrayOf(1, 1, 1, 0, 0, -1, -1, -1)
    val dy = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

    fun gameOfLife(board: Array<IntArray>): Unit {
        val m = board.size
        val n = board.first().size

        val isLived = Array(m) { BooleanArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                isLived[i][j] = isCellLived(board, i, j)
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                board[i][j] = if (isLived[i][j]) 1 else 0
            }
        }
    }

    private fun isCellLived(board: Array<IntArray>, x: Int, y: Int): Boolean {
        val m = board.size
        val n = board.first().size

        var numOfLivingCells = 0
        for (i in dx.indices) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue
            if (board[nx][ny] == 1) numOfLivingCells++
        }

        return when {
            board[x][y] == 1 && numOfLivingCells in 2..3 -> true
            board[x][y] == 0 && numOfLivingCells == 3 -> true
            else -> false
        }
    }
}

