package combinationsum2

import kotlin.properties.Delegates

class Solution {

    lateinit var candidates: IntArray
    var target by Delegates.notNull<Int>()
    var answer = mutableListOf<List<Int>>()

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        this.candidates = candidates.sortedArray()
        this.target = target

        combination(0, 0, mutableListOf())

        return answer
    }

    private fun combination(start: Int, sum: Int, nums: MutableList<Int>) {
        if(sum > target)
            return

        if(sum == target) {
            answer.add(nums.toList())
            return
        }

        var prev = 0
        for(i in start until candidates.size) {
            if(prev != candidates[i]) {
                nums.add(candidates[i])
                combination(i + 1, sum + candidates[i], nums)
                nums.removeAt(nums.lastIndex)
                prev = candidates[i]
            }
        }
    }
}

