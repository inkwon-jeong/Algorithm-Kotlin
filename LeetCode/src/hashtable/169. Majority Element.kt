package majorityelement

import java.lang.Exception

class Solution {
    fun majorityElement(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        nums.forEach { num ->
            val count = map.getOrDefault(num, 0) + 1
            if(count > nums.size / 2)
                return num

            map[num] = count
        }

        throw Exception()
    }
}

