package singlenumber3

class Solution {
    fun singleNumber(nums: IntArray): IntArray {
        var diff = 0
        for (num in nums) {
            diff = diff xor num
        }

        diff = diff and -diff

        val answer = intArrayOf(0, 0)
        for (num in nums) {
            if (num and diff == 0) {
                answer[0] = answer[0] xor num
            } else {
                answer[1] = answer[1] xor num
            }
        }
        return answer
    }
}