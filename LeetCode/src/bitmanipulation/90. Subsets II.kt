package subsets2

class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val n = nums.size
        val last = powerOfTwo(n)
        val answer = mutableSetOf<List<Int>>()

        nums.sort()

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

        return answer.toList()
    }

    private fun powerOfTwo(n: Int): Int {
        var result = 1
        repeat(n) { result *= 2 }
        return result
    }
}

