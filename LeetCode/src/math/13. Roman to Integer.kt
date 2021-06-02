package romantointeger

class Solution {
    fun romanToInt(s: String): Int {
        val romans = hashMapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        var answer = 0
        var prev = 0
        for (i in s.lastIndex downTo 0) {
            val curr = romans[s[i]]!!
            if (curr >= prev) answer += curr
            else answer -= curr
            prev = curr
        }

        return answer
    }
}