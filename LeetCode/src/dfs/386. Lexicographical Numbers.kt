package lexicographicalnumbers

class Solution {

    private val answer = mutableListOf<Int>()

    fun lexicalOrder(n: Int): List<Int> {
        lexicalOrder(n, 0)
        return answer
    }

    private fun lexicalOrder(n: Int, num: Int) {
        for (i in 0..9) {
            val next = num * 10 + i
            if (next == 0) continue
            if (next <= n) {
                answer.add(next)
                lexicalOrder(n, next)
            }
        }
    }
}

