package findpeakelement

class Solution {
    fun findPeakElement(nums: IntArray): Int {
        return findPeakElement(nums, 0, nums.lastIndex)
    }

    private fun findPeakElement(nums: IntArray, start: Int, end: Int): Int {
        if (start == end)
            return start

        val mid = (start + end) / 2
        return if (nums[mid] > nums[mid + 1]) findPeakElement(nums, start, mid)
        else findPeakElement(nums, mid + 1, end)
    }
}

