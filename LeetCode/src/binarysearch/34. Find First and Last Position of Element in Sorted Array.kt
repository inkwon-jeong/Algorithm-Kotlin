package findfirstandlastpositionofelementinsortedarray

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var startIndex = -1
        var endIndex = -1

        var start = 0
        var end = nums.lastIndex

        while (start <= end) {
            val mid = start + (end - start) / 2
            if(nums[mid] == target) {
                if(nums.getOrNull(mid - 1) == target) {
                    end = mid - 1
                } else {
                    startIndex = mid
                    break
                }
            } else if(nums[mid] < target) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        start = 0
        end = nums.lastIndex

        while (start <= end) {
            val mid = start + (end - start) / 2
            if(nums[mid] == target) {
                if(nums.getOrNull(mid + 1) == target) {
                    start = mid + 1
                } else {
                    endIndex = mid
                    break
                }
            } else if(nums[mid] < target) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        return intArrayOf(startIndex, endIndex)
    }
}

