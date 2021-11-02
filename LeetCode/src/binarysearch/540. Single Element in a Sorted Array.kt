package singleelementinasortedarray

class Solution {
    fun singleNonDuplicate(nums: IntArray): Int {
        var start = 0
        var end = nums.size - 1

        while (start < end) {
            var mid = (start + end) / 2
            if (mid % 2 == 1) mid--
            if (nums[mid] != nums[mid + 1]) end = mid else start = mid + 2
        }
        return nums[start]
    }
}

