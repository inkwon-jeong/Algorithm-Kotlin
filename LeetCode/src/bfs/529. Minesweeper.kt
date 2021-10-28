package minesweeper

import java.util.*

class Solution {
    fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
        val m: Int = board.size
        val n: Int = board[0].size
        val queue: Queue<IntArray> = LinkedList()
        queue.add(click)

        while (!queue.isEmpty()) {
            val cell: IntArray = queue.poll()
            val row = cell[0]
            val col = cell[1]
            if (board[row][col] == 'M') { // Mine
                board[row][col] = 'X'
            } else { // Empty
                // Get number of mines first.
                var count = 0
                for (i in -1..1) {
                    for (j in -1..1) {
                        if (i == 0 && j == 0) continue
                        val r = row + i
                        val c = col + j
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue
                        if (board[r][c] == 'M' || board[r][c] == 'X') count++
                    }
                }
                if (count > 0) { // If it is not a 'B', stop further BFS.
                    board[row][col] = '0' + count
                } else { // Continue BFS to adjacent cells.
                    board[row][col] = 'B'
                    for (i in -1..1) {
                        for (j in -1..1) {
                            if (i == 0 && j == 0) continue
                            val r = row + i
                            val c = col + j
                            if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue
                            if (board[r][c] == 'E') {
                                queue.add(intArrayOf(r, c))
                                board[r][c] = 'B' // Avoid to be added again.
                            }
                        }
                    }
                }
            }
        }

        return board
    }
}

