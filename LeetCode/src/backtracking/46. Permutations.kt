package permutations

class Solution {

    lateinit var nums: IntArray
    lateinit var visited: BooleanArray
    lateinit var answer: MutableList<List<Int>>

    fun permute(nums: IntArray): List<List<Int>> {
        this.nums = nums
        visited = BooleanArray(nums.size)
        answer = mutableListOf()
        permute(mutableListOf())
        return answer
    }

    private fun permute(permutation: MutableList<Int>) {
        if(permutation.size == nums.size) {
            answer.add(permutation.toList())
            return
        }

        for(i in nums.indices) {
            if(!visited[i]) {
                visited[i] = true
                permutation.add(nums[i])
                permute(permutation)
                visited[i] = false
                permutation.removeAt(permutation.lastIndex)
            }
        }
    }
}

