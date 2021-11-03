package numberofprovinces

class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val visited = IntArray(isConnected.size)
        var count = 0
        for (i in isConnected.indices) {
            if (visited[i] == 0) {
                findCircleNum(isConnected, visited, i)
                count++
            }
        }
        return count
    }

    private fun findCircleNum(isConnected: Array<IntArray>, visited: IntArray, i: Int) {
        for (j in isConnected.indices) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1
                findCircleNum(isConnected, visited, j)
            }
        }
    }
}

