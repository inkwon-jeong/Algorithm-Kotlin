package validsudoku

class Solution {

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { BooleanArray(10) }
        val columns = Array(9) { BooleanArray(10) }
        val boxes = Array(9) { BooleanArray(10) }

        for(i in 0..8) {
            for(j in 0..8) {
                val cell = board[i][j] - '0'
                if(cell in 1..9) {
                    if(!rows[i][cell] && !columns[j][cell] && !boxes[(i / 3) * 3 + (j / 3)][cell]) {
                        rows[i][cell] = true
                        columns[j][cell] = true
                        boxes[(i / 3) * 3 + (j / 3)][cell] = true
                    } else return false
                }
            }
        }

        return true
    }
}