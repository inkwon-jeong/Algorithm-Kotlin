package longestsubstringwithoutrepeatingcharacters

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var max =  0
        var startIndex = -1
        val map = mutableMapOf<Char, Int>()

        s.forEachIndexed { index, c ->
            val lastIndex = map[c]
            if(lastIndex != null && startIndex < lastIndex)
                startIndex = lastIndex

            val length = index - startIndex
            max = max(max, length)
            map[c] = index
        }

        return max
    }
}