package sumofallsubsetxortotals

class Solution {
    private var sum = 0
    private var depth = 0

    fun subsetXORSum(nums: IntArray): Int {
        for(i in 1..nums.size) {
            depth = i
            subsetXORSum(nums, 0, 0, 0)
        }
        return sum
    }

    fun subsetXORSum(nums: IntArray, start: Int, depth: Int, result: Int) {
        if(this.depth == depth) {
            sum += result
            return
        }

        for(i in start..nums.lastIndex) {
            subsetXORSum(nums, i + 1, depth + 1, result xor nums[i])
        }
    }
}

