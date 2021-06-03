package twosum2inputarrayissorted

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var start = 0
        var end = numbers.lastIndex
        var sum = numbers[start] + numbers[end]

        while (sum != target) {
            when {
                sum < target -> start++
                sum > target -> end--
            }
            sum = numbers[start] + numbers[end]
        }

        return intArrayOf(start + 1, end + 1)
    }
}

