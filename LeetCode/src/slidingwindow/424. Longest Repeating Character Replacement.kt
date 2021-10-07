package longestrepeatingcharacterreplacement

import kotlin.math.max

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val len: Int = s.length
        val count = IntArray(26)
        var start = 0
        var maxCount = 0
        var maxLength = 0
        for (end in 0 until len) {
            maxCount = max(maxCount, ++count[s[end] - 'A'])
            while (end - start + 1 - maxCount > k) {
                count[s[start] - 'A']--
                start++
            }
            maxLength = max(maxLength, end - start + 1)
        }
        return maxLength
    }
}

