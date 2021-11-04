package optimaldivision

class Solution {
    fun optimalDivision(nums: IntArray): String {
        val builder = StringBuilder()
        builder.append(nums[0])
        for (i in 1 until nums.size) {
            if (i == 1 && nums.size > 2) {
                builder.append("/(").append(nums[i])
            } else {
                builder.append("/").append(nums[i])
            }
        }
        return if (nums.size > 2) builder.append(")").toString() else builder.toString()
    }
}

