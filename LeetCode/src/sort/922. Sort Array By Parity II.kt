package sortarraybyparity2

class Solution {
    fun sortArrayByParityII(nums: IntArray): IntArray {
        var evenIndex = 0
        var oddIndex = 1

        while (evenIndex < nums.size && oddIndex < nums.size) {
            while(evenIndex < nums.size && nums[evenIndex] % 2 == 0)
                evenIndex += 2

            while(oddIndex < nums.size && nums[oddIndex] % 2 == 1)
                oddIndex += 2

            if(evenIndex < nums.size && oddIndex < nums.size) {
                val temp = nums[evenIndex]
                nums[evenIndex] = nums[oddIndex]
                nums[oddIndex] = temp
            }
        }

        return nums
    }
}
