package threesum

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val answer = mutableSetOf<List<Int>>()
        nums.forEachIndexed { index, first ->
            val map = mutableMapOf<Int, Int>()
            for(i in index + 1..nums.lastIndex) {
                val second = nums[i]
                val third = -(first + second)
                if(map.containsKey(third)) {
                    val list = listOf(first, second, third).sorted()
                    answer.add(list)
                }
                map[second] = i
            }
        }

        return answer.toList()
    }
}

