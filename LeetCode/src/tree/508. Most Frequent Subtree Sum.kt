package mostfrequentsubtreesum

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    private var max = 0
    private val sums = mutableMapOf<Int, Int>()
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        if (root == null) return intArrayOf()
        sum(root)
        return sums.filterValues { it == max }
            .map { (num, _) -> num }
            .toIntArray()
    }

    private fun sum(node: TreeNode): Int {
        var sum = 0
        sum += node.`val`
        if (node.left != null) sum += sum(node.left!!)
        if (node.right != null) sum += sum(node.right!!)

        sums[sum] = sums.getOrDefault(sum, 0) + 1
        if (sums[sum]!! > max)
            max = sums[sum]!!

        return sum
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

