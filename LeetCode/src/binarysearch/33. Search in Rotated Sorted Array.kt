package searchinrotatedsortedarray

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.lastIndex
        var indexed = 0

        while (start <= end) {
            val mid = (start + end) / 2

            val startValue = nums[start]
            val endValue = nums[end]
            val midValue = nums[mid]

            if(startValue <= endValue) {
                indexed = start
                break
            }

            if(midValue >= startValue) {
                start = mid + 1
            } else {
                start += 1
                end = mid
            }
        }

        var answer = -1
        start = 0
        end = nums.lastIndex

        while (start <= end) {
            val mid = (start + end) / 2
            val index = (mid + indexed) % nums.size

            if(nums[index] == target) {
                answer = index
                break
            }

            if(nums[index] > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        return answer
    }
}

