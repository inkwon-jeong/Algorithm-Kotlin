package battleshipsinaboard

class Solution {

    private val dx = intArrayOf(1, 0, -1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)

    private lateinit var board: Array<CharArray>
    private lateinit var visited: Array<BooleanArray>

    private var m = 0
    private var n = 0

    fun countBattleships(board: Array<CharArray>): Int {
        this.board = board
        m = board.size
        n = board.first().size
        visited = Array(m) { BooleanArray(n) }

        var count = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (!visited[i][j] && board[i][j] == 'X') {
                    count++
                    dfs(i, j)
                }
            }
        }

        return count
    }

    private fun dfs(x: Int, y: Int) {
        for (i in dx.indices) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx !in 0 until m || ny !in 0 until n) continue
            if (!visited[nx][ny] && board[nx][ny] == 'X') {
                visited[nx][ny] = true
                dfs(nx, ny)
            }
        }
    }
}

