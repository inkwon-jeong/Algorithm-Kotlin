package programming3

import kotlin.math.min

class Solution {

    lateinit var dest: IntArray
    lateinit var visited: BooleanArray
    lateinit var m: IntArray
    var answer = Int.MAX_VALUE

    fun solution(m: IntArray): Int {
        this.m = m
        dest = IntArray(m.size) { -1 }
        visited = BooleanArray(m.size)

        m.forEachIndexed { index, _ -> destination(index) }

        move(0, 0)

        return answer
    }

    private fun destination(index: Int): Int {
        if (m[index] == 0) {
            dest[index] = index
            return index
        }

        val d = index + m[index]
        dest[index] = when {
            d >= m.lastIndex -> m.lastIndex
            d <= 0 -> 0
            dest[d] != -1 -> dest[d]
            else -> destination(d)
        }

        return dest[index]
    }

    private fun move(start: Int, count: Int) {
        if (start >= m.lastIndex) {
            answer = min(answer, count)
            return
        }

        if(count > answer)
            return

        if (visited[start])
            return

        visited[start] = true

        for (i in (start + 1)..(start + 6)) {
            val index = when {
                i >= m.lastIndex -> m.lastIndex
                else -> i
            }
            val dest = dest[index]

            move(dest, count + 1)
        }

        visited[start] = false
    }
}