package searcha2dmatrix2

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix.first().size

        matrix.forEach { row ->
            var start = 0
            var end = n - 1

            while (start <= end) {
                val mid = (start + end) / 2
                val value = row[mid]
                when {
                    value == target -> return true
                    value > target -> end = mid - 1
                    value < target -> start = mid + 1
                }
            }
        }

        return false
    }
}

