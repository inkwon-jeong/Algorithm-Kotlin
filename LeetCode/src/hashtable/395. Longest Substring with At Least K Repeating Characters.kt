package longestsubstringwithatleastkrepeatingcharacters

import kotlin.math.max

class Solution {
    fun longestSubstring(s: String?, k: Int): Int {
        if (s == null || s.isEmpty()) return 0
        return if (k < 2) s.length
        else helper(s, 0, s.length, k)
    }

    private fun helper(s: String, l: Int, r: Int, k: Int): Int {
        if (l >= r) return 0

        val freq = IntArray(26)
        for (i in l until r) freq[s[i] - 'a']++

        var valid = true
        var i = 0
        while (i < 26 && valid) {
            if (freq[i] in 1 until k) valid = false
            i++
        }
        if (valid) return r - l

        var best = 0
        var start = l
        for (j in l until r) {
            if (freq[s[j] - 'a'] < k) {
                best = max(best, helper(s, start, j, k))
                start = j + 1
            }
        }
        best = max(best, helper(s, start, r, k))
        return best
    }
}

