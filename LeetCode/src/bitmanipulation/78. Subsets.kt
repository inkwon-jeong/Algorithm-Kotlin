package subsets

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val n = nums.size
        val last = powerOfTwo(n)
        val answer = mutableListOf<List<Int>>()

        for (i in 0 until last) {
            var bit = i
            val subset = mutableListOf<Int>()
            for (j in 0 until n) {
                if (bit and 1 == 1)
                    subset.add(nums[j])
                bit = bit ushr 1
            }
            answer.add(subset)
        }

        return answer
    }

    private fun powerOfTwo(n: Int): Int {
        var result = 1
        repeat(n) { result *= 2 }
        return result
    }
}

