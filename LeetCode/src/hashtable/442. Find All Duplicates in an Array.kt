package findallduplicatesinanarray

import kotlin.math.abs

class Solution {
    fun findDuplicates(nums: IntArray): List<Int> {
        val res: MutableList<Int> = ArrayList()
        for (element in nums) {
            val index = abs(element) - 1
            if (nums[index] < 0) res.add(abs(index + 1))
            nums[index] = -nums[index]
        }
        return res
    }
}
