package combinationsum

import kotlin.properties.Delegates

class Solution {

    lateinit var candidates: IntArray
    var target by Delegates.notNull<Int>()
    var answer = mutableListOf<List<Int>>()

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        this.candidates = candidates
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

        for(i in start until candidates.size) {
            nums.add(candidates[i])
            combination(i, sum + candidates[i], nums)
            nums.removeAt(nums.lastIndex)
        }
    }
}

