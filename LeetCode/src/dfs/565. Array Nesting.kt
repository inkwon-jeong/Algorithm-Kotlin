package arraynesting

class Solution {
    fun arrayNesting(nums: IntArray): Int {
        var res = 0
        val n = nums.size
        val seen = BooleanArray(n)
        for (num in nums) {
            var i = num
            var cnt = 0
            while (!seen[i]) {
                seen[i] = true
                cnt++
                i = nums[i]
            }
            res = res.coerceAtLeast(cnt)
        }
        return res
    }
}

