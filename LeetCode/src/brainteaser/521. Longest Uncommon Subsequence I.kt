package longestuncommonsubsequence

import kotlin.math.max

class Solution {
    fun findLUSlength(a: String, b: String): Int {
        if(a.length != b.length)
            return max(a.length, b.length)

        return if(a == b) -1 else a.length
    }
}

