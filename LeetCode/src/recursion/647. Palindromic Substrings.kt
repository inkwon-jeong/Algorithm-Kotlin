package palindromicsubstrings

class Solution {
    var count = 0
    fun countSubstrings(s: String?): Int {
        if (s == null || s.isEmpty()) return 0
        for (i in s.indices) {
            extendPalindrome(s, i, i)
            extendPalindrome(s, i, i + 1)
        }
        return count
    }

    private fun extendPalindrome(s: String, start: Int, end: Int) {
        var left = start
        var right = end
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            count++
            left--
            right++
        }
    }
}

