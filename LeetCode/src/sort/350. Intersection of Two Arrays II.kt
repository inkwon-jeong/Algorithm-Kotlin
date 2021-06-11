package intersectionoftwoarrays2

class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val map = mutableMapOf<Int, Int>()

        nums1.forEach {
            val count = map.getOrDefault(it, 0)
            map[it] = count + 1
        }

        nums2.forEach {
            val count = map[it]
            if(count != null && count > 0) {
                answer.add(it)
                map[it] = count - 1
            }
        }

        return answer.toIntArray()
    }
}

