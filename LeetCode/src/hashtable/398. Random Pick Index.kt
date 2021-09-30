package randompickindex

class Solution(nums: IntArray) {

    private val hashMap = hashMapOf<Int, MutableList<Int>>()

    init {
        nums.forEachIndexed { index, num ->
            val indexes = hashMap.getOrPut(num) { mutableListOf() }
            indexes.add(index)
        }
    }

    fun pick(target: Int): Int {
        val indexes = hashMap[target]!!
        return indexes.random()
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(nums)
 * var param_1 = obj.pick(target)
 */

