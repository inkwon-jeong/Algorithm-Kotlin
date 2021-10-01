package arithmeticslices

class Solution {

    fun numberOfArithmeticSlices(nums: IntArray): Int {
        val d = IntArray(nums.size + 1)
        val diffs = IntArray(nums.size - 1)
        for (i in 1 until nums.size) {
            diffs[i - 1] = nums[i] - nums[i - 1]
        }

        var answer = 0
        var count = 0
        var prev: Int? = null

        for (diff in diffs) {
            if (prev == null) {
                count = 1
            } else {
                if (prev == diff)
                    count++
                else {
                    answer += numberOfCombination(d, count + 1)
                    count = 1
                }
            }
            prev = diff
        }

        answer += numberOfCombination(d, count)
        return answer
    }

    private fun numberOfCombination(d: IntArray, num: Int): Int {
        if (num in 0..2) return 0
        if (d[num] != 0) return d[num]

        d[num] = ((num - 3) + 1) + numberOfCombination(d, num - 1)
        return d[num]
    }
}