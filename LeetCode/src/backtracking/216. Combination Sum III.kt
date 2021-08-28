package combinationsum3

class Solution {

    private val answer = mutableListOf<List<Int>>()

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        combinationSum3(k, n, 1, 0, mutableListOf())
        return answer
    }

    private fun combinationSum3(k: Int, n: Int, num: Int, sum: Int, nums: MutableList<Int>) {
        if (sum > n)
            return

        if (nums.size == k && sum == n) {
            answer.add(nums.toList())
            return
        }

        if (nums.size >= k)
            return

        for (i in num..9) {
            nums.add(i)
            combinationSum3(k, n, i + 1, sum + i, nums)
            nums.removeAt(nums.lastIndex)
        }
    }
}

