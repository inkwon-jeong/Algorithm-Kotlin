package singlenumber2

class Solution {
    fun singleNumber(nums: IntArray): Int {
        var one = 0
        var two = 0
        nums.forEach { num ->
            one = one.xor(num).and(two.inv())
            two = two.xor(num).and(one.inv())
        }

        return one
    }
}

