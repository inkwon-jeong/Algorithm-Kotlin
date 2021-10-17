package minimummovestoequalarrayelements2

class Solution {
    fun minMoves2(nums: IntArray): Int {
        nums.sort()
        var start = 0
        var end = nums.lastIndex
        var moves = 0
        while (start < end) {
            moves += nums[end--] - nums[start++]
        }
        return moves
    }
}