package reversestring

class Solution {
    fun reverseString(s: CharArray): Unit {
        var index = 0
        while (index < s.size / 2) {
            val temp = s[index]
            s[index] = s[s.lastIndex - index]
            s[s.lastIndex - index] = temp
            index++
        }
    }
}

