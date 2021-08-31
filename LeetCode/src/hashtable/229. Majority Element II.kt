package majorityelement2

class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        if (nums.isEmpty()) return emptyList()
        val result = mutableListOf<Int>()
        var number1 = nums[0]
        var number2 = nums[0]
        var count1 = 0
        var count2 = 0
        val n = nums.size

        nums.forEach { num ->
            when {
                num == number1 -> count1++
                num == number2 -> count2++
                count1 == 0 -> {
                    number1 = num
                    count1 = 1
                }
                count2 == 0 -> {
                    number2 = num
                    count2 = 1
                }
                else -> {
                    count1--
                    count2--
                }
            }
        }

        count1 = 0
        count2 = 0

        nums.forEach { num ->
            if (num == number1) count1++
            else if (num == number2) count2++
        }

        if (count1 > n / 3) result.add(number1)
        if (count2 > n / 3) result.add(number2)

        return result
    }
}

