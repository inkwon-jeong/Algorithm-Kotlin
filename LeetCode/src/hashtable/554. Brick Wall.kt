package brickwall

import kotlin.math.max

class Solution {
    fun leastBricks(wall: List<List<Int>>): Int {
        val map: MutableMap<Int?, Int?> = HashMap()

        var count = 0
        for (row in wall) {
            var sum = 0
            for (i in 0 until row.size - 1) {
                sum += row[i]
                map[sum] = map.getOrDefault(sum, 0)!! + 1
                count = max(count, map[sum]!!)
            }
        }

        return wall.size - count
    }
}

