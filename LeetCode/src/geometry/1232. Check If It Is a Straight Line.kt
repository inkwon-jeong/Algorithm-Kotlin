package checkifitisastraightline

class Solution {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val sortedCoordinates = coordinates.sortedBy { it.first() }

        val x = (sortedCoordinates[1][0] - sortedCoordinates[0][0])
        val y = (sortedCoordinates[1][1] - sortedCoordinates[0][1])
        val lean = if(x == 0) 0  else y / x.toFloat()

        for (i in 1 until sortedCoordinates.lastIndex) {
            val curX = (sortedCoordinates[i + 1][0] - sortedCoordinates[i][0])
            val curY = (sortedCoordinates[i + 1][1] - sortedCoordinates[i][1])
            val cur = if(curX == 0) 0  else curY / curX.toFloat()
            if(lean != cur)
                return false
        }

        return true
    }
}

