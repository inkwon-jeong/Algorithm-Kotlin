package palindromepartitioning

class Solution {

    private lateinit var answer: MutableList<List<String>>
    private lateinit var isPalindrome: Array<BooleanArray>

    fun partition(s: String): List<List<String>> {
        val n = s.length
        isPalindrome = Array(n) { BooleanArray(n) }
        answer = mutableListOf()
        partition(s, 0, mutableListOf())
        return answer
    }

    private fun partition(s: String, start: Int, palindromes: MutableList<String>) {
        if (start == s.length) {
            answer.add(palindromes.toList())
            return
        }

        for (end in start until s.length) {
            val result = when {
                start == end -> true
                start + 1 == end && s[start] == s[end] -> true
                s[start] == s[end] && isPalindrome[start + 1][end - 1] -> true
                else -> false
            }

            if(result) {
                isPalindrome[start][end] = true
                palindromes.add(s.substring(start, end + 1))
                partition(s, end + 1, palindromes)
                palindromes.removeAt(palindromes.lastIndex)
            }
        }
    }
}

