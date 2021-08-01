package combinations

class Solution {

    private val answer = mutableListOf<List<Int>>()

    fun combine(n: Int, k: Int): List<List<Int>> {
        combination(n, k, 1, 0, mutableListOf())
        return answer
    }

    private fun combination(n: Int, k: Int, start: Int, depth: Int, list: MutableList<Int>) {
        if(depth == k) {
            answer.add(list.toList())
            return
        }

        for (i in start..n) {
            list.add(i)
            combination(n, k, i + 1, depth + 1, list)
            list.remove(i)
        }
    }
}

