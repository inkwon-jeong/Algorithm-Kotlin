package setmatrixzeroes

class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val m = matrix.size
        val n = matrix.first().size

        val rows = mutableSetOf<Int>()
        val columns = mutableSetOf<Int>()

        for(i in 0 until m) {
            for(j in 0 until n) {
                if(matrix[i][j] == 0) {
                    rows.add(i)
                    columns.add(j)
                }
            }
        }

        for(i in 0 until m) {
            for(j in 0 until n) {
                if(rows.contains(i) || columns.contains(j))
                    matrix[i][j] = 0
            }
        }
    }
}

