package maximumsubarray

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val d = Array(nums.size) { 0 }
        var sum = nums.first()
        var max = sum

        for (i in 1..nums.lastIndex) {
            val num = nums[i]
            if (sum + num > num) {
                sum += num
            } else {
                sum = num
            }

            if(max < sum)
                max = sum
        }

        return max
    }
}
