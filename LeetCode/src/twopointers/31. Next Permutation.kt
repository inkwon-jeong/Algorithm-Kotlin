package nextpermutation

class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        for(i in (nums.lastIndex - 1) downTo 0) {
            for(j in (i + 1)..nums.lastIndex) {
                if(nums[i] < nums[j]) {
                    val temp = nums[i]
                    nums[i] = nums[j]
                    nums[j] = temp
                    return
                }
            }

            for(j in (i + 1)..nums.lastIndex) {
                if(nums[j - 1] > nums[j]) {
                    val temp = nums[j]
                    nums[j] = nums[j - 1]
                    nums[j - 1] = temp
                } else break
            }
        }
    }
}

