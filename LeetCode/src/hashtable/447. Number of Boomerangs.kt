package numberofboomerangs

class Solution {
    fun numberOfBoomerangs(points: Array<IntArray>): Int {
        var res = 0

        val map: MutableMap<Int, Int> = HashMap()
        for (i in points.indices) {
            for (j in points.indices) {
                if (i == j) continue
                val d: Int = getDistance(points[i], points[j])
                map[d] = map.getOrDefault(d, 0) + 1
            }
            for (`val` in map.values) {
                res += `val` * (`val` - 1)
            }
            map.clear()
        }

        return res
    }

    private fun getDistance(a: IntArray, b: IntArray): Int {
        val dx = a[0] - b[0]
        val dy = a[1] - b[1]
        return dx * dx + dy * dy
    }
}

