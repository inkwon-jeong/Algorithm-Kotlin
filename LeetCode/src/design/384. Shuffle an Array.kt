package shuffleanarray

class Solution(private val nums: IntArray) {

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        return nums
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        val set = nums.toMutableSet()
        val randoms = IntArray(nums.size)
        for (i in nums.indices) {
            val random = set.random()
            randoms[i] = random
            set.remove(random)
        }
        return randoms
    }
}