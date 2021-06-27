package longestpalindromicsubstring

class Solution {
    fun longestPalindrome(s: String): String {
        val d = Array(s.length) { BooleanArray(s.length) }

        var max = 0
        var str = "${s[0]}"

        for (index in 0..s.lastIndex) {
            d[index][index] = true

            var start = 0
            while (start != index) {
                if (s[start] == s[index] &&
                    (index - start == 1 || d[start + 1][index - 1])
                ) {
                    d[start][index] = true
                    if (max < index - start) {
                        max = index - start
                        str = s.substring(start, index + 1)
                    }
                }
                start++
            }
        }

        return str
    }
}

