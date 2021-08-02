package wordsearch

class Solution {

    private lateinit var visited: Array<BooleanArray>
    private lateinit var board: Array<CharArray>
    private lateinit var word: String
    private var m = 0
    private var n = 0
    private var isFinished = false

    private val dx = intArrayOf(0, 1, 0, -1)
    private val dy = intArrayOf(1, 0, -1, 0)

    fun exist(board: Array<CharArray>, word: String): Boolean {
        m = board.size
        n = board.first().size

        this.board = board
        this.word = word
        visited = Array(m) { BooleanArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (!isFinished && board[i][j] == word[0]) {
                    visited[i][j] = true
                    backtracking(i, j, 1)
                    visited[i][j] = false
                }
            }
        }

        return isFinished
    }

    private fun backtracking(x: Int, y: Int, index: Int) {
        if (isFinished)
            return

        if(index == word.length) {
            isFinished = true
            return
        }

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue

            if(!visited[nx][ny] && board[nx][ny] == word[index]) {
                visited[nx][ny] = true
                backtracking(nx, ny, index + 1)
                visited[nx][ny] = false
            }
        }
    }
}

