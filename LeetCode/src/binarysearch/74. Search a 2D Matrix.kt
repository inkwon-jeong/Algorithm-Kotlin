package searcha2dmatrix

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix.first().size

        var row = 0

        var start = 0
        var end = m - 1
        label@ while (start <= end) {
            val mid = (start + end) / 2
            when {
                matrix[mid][0] == target -> { row = mid; break@label }
                matrix[mid][0] > target -> end = mid - 1
                matrix[mid][0] < target -> start = mid + 1
            }
            row = end
        }

        if(row < 0)
            return false

        start = 0
        end = n - 1
        while (start <= end) {
            val mid = (start + end) / 2
            when {
                matrix[row][mid] == target -> return true
                matrix[row][mid] > target -> end = mid - 1
                matrix[row][mid] < target -> start = mid + 1
            }
        }
        return false
    }
}

