package maximumlengthofpairchain

class Solution {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        pairs.sortBy { it[1] }
        var count = 0
        var i = 0
        val n = pairs.size
        while (i < n) {
            count++
            val curEnd = pairs[i][1]
            while (i < n && pairs[i][0] <= curEnd) i++
        }
        return count
    }
}

