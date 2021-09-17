package topkfrequentelements

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val hashMap = hashMapOf<Int, Int>()
        for (num in nums) {
            hashMap[num] = hashMap.getOrDefault(num, 0) + 1
        }

        val sorted = hashMap.toList().sortedByDescending { it.second }
        return sorted.subList(0, k).map { it.first }.toIntArray()
    }
}

