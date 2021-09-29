package longestsubstringwithatleastkrepeatingcharacters

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun longestSubstring(s: String, k: Int): Int {
        val hashMap = hashMapOf<Char, MutableList<Int>>()
        var startIndex = -1
        var endIndex = -1
        s.forEachIndexed { index, c ->
            val indexes = hashMap.getOrPut(c) { mutableListOf() }
            indexes.add(index)

            if (indexes.size >= k) {
                startIndex =
                    if (startIndex == -1) indexes.first()
                    else min(startIndex, indexes.first())

                endIndex =
                    if (endIndex == -1) indexes.last()
                    else max(startIndex, indexes.last())
            }
        }

        return if (startIndex == -1 || endIndex == -1) 0 else (endIndex - startIndex) + 1
    }
}

