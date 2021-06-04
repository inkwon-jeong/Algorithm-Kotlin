package intersectionoftwoarrays

class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val answer = mutableSetOf<Int>()
        val nums = nums1.sortedArray()

        nums2.forEach { num ->
            var start = 0
            var end = nums.lastIndex

            loop@ while (start <= end) {
                val mid = (start + end) / 2
                when {
                    nums[mid] > num -> end = mid - 1
                    nums[mid] < num -> start = mid + 1
                    else -> {
                        answer.add(num)
                        break@loop
                    }
                }
            }
        }

        return answer.toIntArray()
    }
}

