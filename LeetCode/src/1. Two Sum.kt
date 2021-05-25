package twosum

import java.lang.Exception

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, first ->
            val second = target - first
            if(hashMap.containsKey(second)) return intArrayOf(index, hashMap[second]!!)
            hashMap[first] = index
        }
        throw Exception()
    }
}