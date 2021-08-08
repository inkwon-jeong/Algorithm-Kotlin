package graycode

class Solution {

    private var n = 0
    private var m = 0
    private var isFinished = false
    private lateinit var visited: BooleanArray
    private lateinit var nums: MutableList<Int>
    private lateinit var answer: List<Int>


    fun grayCode(n: Int): List<Int> {
        this.n = n
        this.m = powerOfTwo(n)
        visited = BooleanArray(m)
        nums = mutableListOf()

        nums.add(0)
        visited[0] = true
        grayCode(1, 0)

        return answer
    }

    private fun grayCode(depth: Int, num: Int) {
        if (isFinished)
            return

        if (depth == m) {
            isFinished = true
            answer = nums.toList()
            return
        }

        var bit = 1
        repeat(n) {
            val next = num.xor(bit)
            if (!visited[next]) {
                visited[next] = true
                nums.add(next)
                grayCode(depth + 1, next)
                visited[next] = false
                nums.removeAt(nums.lastIndex)
            }
            bit = bit.shl(1)
        }
    }

    private fun powerOfTwo(n: Int): Int {
        var result = 1
        repeat(n) { result *= 2 }
        return result
    }
}