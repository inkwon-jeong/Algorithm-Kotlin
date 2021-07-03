package matrix

class Solution {

    private var isFinished = false
    private val rows = Array(9) { BooleanArray(10) }
    private val columns = Array(9) { BooleanArray(10) }
    private val boxes = Array(9) { BooleanArray(10) }

    fun solveSudoku(board: Array<CharArray>): Unit {
        for (i in 0..8) {
            for (j in 0..8) {
                val cell = board[i][j] - '0'
                if (cell in 1..9) {
                    rows[i][cell] = true
                    columns[j][cell] = true
                    boxes[(i / 3) * 3 + (j / 3)][cell] = true
                }
            }
        }

        fillCell(board, 0, 0)
    }

    private fun fillCell(board: Array<CharArray>, i: Int, j: Int) {
        if (isFinished)
            return

        if (i >= 9) {
            isFinished = true
            return
        }

        val cell = board[i][j] - '0'
        if (cell in 1..9) {
            if (j + 1 == 9) {
                fillCell(board, i + 1, 0)
            } else {
                fillCell(board, i, j + 1)
            }
            return
        }

        for (char in '1'..'9') {
            val num = char - '0'
            if (!rows[i][num] && !columns[j][num] && !boxes[(i / 3) * 3 + (j / 3)][num]) {
                rows[i][num] = true
                columns[j][num] = true
                boxes[(i / 3) * 3 + (j / 3)][num] = true
                board[i][j] = char

                if (j + 1 == 9) {
                    fillCell(board, i + 1, 0)
                } else {
                    fillCell(board, i, j + 1)
                }

                if(!isFinished) {
                    rows[i][num] = false
                    columns[j][num] = false
                    boxes[(i / 3) * 3 + (j / 3)][num] = false
                    board[i][j] = '.'
                }
            }
        }
    }
}