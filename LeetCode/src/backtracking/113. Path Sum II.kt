package pathsum2

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

    private val answer = mutableListOf<List<Int>>()

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        pathSum(root, targetSum, 0, mutableListOf())
        return answer
    }

    private fun pathSum(node: TreeNode?, targetSum: Int, sum: Int, vals: MutableList<Int>) {
        if (node == null) {
            if(sum == targetSum) {
                answer.add(vals.toList())
            }
            return
        }

        vals.add(node.`val`)
        pathSum(node.left, targetSum, sum + node.`val`, vals)
        pathSum(node.right, targetSum, sum + node.`val`, vals)
        vals.removeAt(vals.lastIndex)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

