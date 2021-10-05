package maximumxoroftwonumbersinanarray

class Solution {
    fun findMaximumXOR(nums: IntArray): Int {
        var max = 0
        var mask = 0
        for (i in 31 downTo 0) {
            mask = mask or (1 shl i)
            val set: MutableSet<Int> = HashSet()
            for (num in nums) {
                set.add(num and mask)
            }
            val tmp = max or (1 shl i)
            for (prefix in set) {
                if (set.contains(tmp xor prefix)) {
                    max = tmp
                    break
                }
            }
        }
        return max
    }
}

