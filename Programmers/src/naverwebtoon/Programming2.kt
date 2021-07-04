package programming2

import kotlin.math.max

class Solution {

    lateinit var bricks: IntArray
    var n = 0
    var k = 0
    var max = 0

    fun solution(bricks: IntArray, n: Int, k: Int): Int {
        this.bricks = bricks
        this.n = n
        this.k = k

        combination(1, 0, 0)

        return (n * (k - 1)) - max
    }

    private fun combination(start: Int, depth: Int, sum: Int) {
        if (depth == k - 1) {
            max = max(max, sum)
            return
        }

        for (i in start until bricks.lastIndex) {
            combination(i + 2, depth + 1, sum + bricks[i])
        }
    }
}
