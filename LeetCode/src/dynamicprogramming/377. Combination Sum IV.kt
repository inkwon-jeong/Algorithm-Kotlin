package combinationsum4

class Solution {
    private lateinit var d: IntArray

    fun combinationSum4(nums: IntArray, target: Int): Int {
        d = IntArray(target + 1) { -1 }
        d[0] = 1
        return combination(nums, target)
    }

    private fun combination(nums: IntArray, target: Int): Int {
        if (d[target] != -1) {
            return d[target]
        }
        var count = 0
        for (i in nums.indices) {
            if (target >= nums[i]) {
                count += combination(nums, target - nums[i])
            }
        }
        d[target] = count
        return count
    }
}