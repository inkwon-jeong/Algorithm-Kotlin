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
        if (root == null)
            return emptyList()

        pathSum(root, targetSum, 0, mutableListOf())
        return answer
    }

    private fun pathSum(node: TreeNode, targetSum: Int, sum: Int, vals: MutableList<Int>) {
        val left = node.left
        val right = node.right

        if (left == null && right == null) {
            if (sum + node.`val` == targetSum) {
                vals.add(node.`val`)
                answer.add(vals.toList())
                vals.removeAt(vals.lastIndex)
            }
            return
        }

        if (left != null) {
            vals.add(node.`val`)
            pathSum(left, targetSum, sum + node.`val`, vals)
            vals.removeAt(vals.lastIndex)
        }

        if (right != null) {
            vals.add(node.`val`)
            pathSum(right, targetSum, sum + node.`val`, vals)
            vals.removeAt(vals.lastIndex)
        }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

