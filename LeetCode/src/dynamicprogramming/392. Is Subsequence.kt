package issubsequence

class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0

        s.forEach { c ->
            var contains = false
            while (i < t.length) {
                if (c == t[i++]) {
                    contains = true
                    break
                }
            }

            if(!contains)
                return false
        }

        return true
    }
}

